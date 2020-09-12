package net.tomofiles.astar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Astar {
    private final Graph graph;
    private final Coordinate start;
    private final Coordinate goal;
    private final OpenList openList;
    private final ClosedList closedList;

    public Astar(Graph graph, Coordinate start, Coordinate goal) {
        this.graph = graph;
        this.start = start;
        this.goal = goal;
        this.openList = new OpenList();
        this.closedList = new ClosedList();

        this.graph.calculateHeuristic(this.goal);
    }

    public List<Coordinate> findPath() {
        this.openList.push(this.graph.getNode(this.start));
        while (!this.openList.isEmpty()) {
            Node currentNode = this.openList.pull();
            if (currentNode.getCoordinate().equals(this.goal)) {  
                return this.getPath(currentNode).stream()
                        .map(Node::getCoordinate)
                        .collect(Collectors.toList());
            }
            this.closedList.push(currentNode);
            List<Node> adjacentNodes = this.graph.getAdjacentNodes(currentNode.getCoordinate());
            for (Node adjacentNode : adjacentNodes) {
                int cost = AstarUtils.calculateCost(currentNode, adjacentNode);
                if (this.notContainsOpenAndClosedList(adjacentNode)) {
                    this.openList.push(adjacentNode);
                    adjacentNode.setTotalCost(cost);
                    adjacentNode.setParent(currentNode);
                } else if (this.containsOpenListAndCostIsLowerThanThat(adjacentNode, cost)) {
                    this.openList.remove(adjacentNode);
                    this.openList.push(adjacentNode);
                    adjacentNode.setTotalCost(cost);
                    adjacentNode.setParent(currentNode);
                } else if (this.containsClosedListAndCostIsLowerThanThat(adjacentNode, cost)) {
                    this.openList.push(adjacentNode);
                    adjacentNode.setTotalCost(cost);
                    adjacentNode.setParent(currentNode);
                }
            }
        }
        return new ArrayList<>();
    }

    private List<Node> getPath(Node currentNode) {
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

    private boolean notContainsOpenAndClosedList(Node adjacentNode) {
        return !this.openList.contains(adjacentNode) && !this.closedList.contains(adjacentNode);
    }

    private boolean containsOpenListAndCostIsLowerThanThat(Node adjacentNode, int cost) {
        if (!this.openList.contains(adjacentNode)) return false;
        return this.openList.stream()
                .filter(adjacentNode::equals)
                .anyMatch(node -> node.getTotalCost() > cost);
    }

    private boolean containsClosedListAndCostIsLowerThanThat(Node adjacentNode, int cost) {
        if (!this.closedList.contains(adjacentNode)) return false;
        return this.closedList.stream()
                .filter(adjacentNode::equals)
                .anyMatch(node -> node.getTotalCost() > cost);
    }
}