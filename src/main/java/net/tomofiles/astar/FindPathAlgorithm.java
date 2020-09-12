package net.tomofiles.astar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static net.tomofiles.astar.PushOpenListCondition.notContainsOpenAndClosedList;
import static net.tomofiles.astar.PushOpenListCondition.containsOpenListAndCostIsLowerThanThat;
import static net.tomofiles.astar.PushOpenListCondition.containsClosedListAndCostIsLowerThanThat;

public class FindPathAlgorithm {
    public static List<Coordinate> execute(
            Graph graph,
            Coordinate start,
            Coordinate goal,
            OpenList openList,
            ClosedList closedList) {
        openList.push(graph.getNode(start));
        while (!openList.isEmpty()) {
            Node currentNode = openList.pull();
            if (currentNode.getCoordinate().equals(goal)) {  
                return getShortestPath(currentNode).stream()
                        .map(Node::getCoordinate)
                        .collect(Collectors.toList());
            }
            closedList.push(currentNode);
            List<Node> adjacentNodes = graph.getAdjacentNodes(currentNode.getCoordinate());
            for (Node adjacentNode : adjacentNodes) {
                int cost = AstarUtils.calculateCost(currentNode, adjacentNode);
                if (notContainsOpenAndClosedList(openList, closedList, adjacentNode)
                        || containsOpenListAndCostIsLowerThanThat(openList, adjacentNode, cost)
                        || containsClosedListAndCostIsLowerThanThat(closedList, adjacentNode, cost)) {
                    openList.push(adjacentNode);
                    adjacentNode.setTotalCost(cost);
                    adjacentNode.setParent(currentNode);
                }
            }
        }
        return new ArrayList<>();
    }

    private static List<Node> getShortestPath(Node currentNode) {
        List<Node> path = new ArrayList<>();
        path.add(currentNode);
        Node parent;
        while ((parent = currentNode.getParent()) != null) {
            path.add(parent);
            currentNode = parent;
        }
        Collections.reverse(path);
        return path;
    }
}