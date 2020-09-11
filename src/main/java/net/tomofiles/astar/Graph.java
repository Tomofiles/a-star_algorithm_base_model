package net.tomofiles.astar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Graph {
    private static final int DEFAULT_COST = 1;

    private final List<Node> nodes;

    public Graph(int rows, int cols, List<Block> blocks) {
        this.nodes = initNodes(rows, cols, blocks);
    }

    private static List<Node> initNodes(int rows, int cols, List<Block> blocks) {
        List<Node> nodes = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Coordinate coordinate = new Coordinate(row, col);
                if (blocks.stream().anyMatch(block -> block.includes(coordinate))) {
                    nodes.add(new Node(coordinate, Condition.newBlockCondition(DEFAULT_COST)));
                } else {
                    nodes.add(new Node(coordinate, Condition.newCondition(DEFAULT_COST)));
                }
            }
        }
        return nodes;
    }

    public Node getNode(Coordinate coordinate) {
        return this.nodes.stream()
                .filter(node -> node.getCoordinate().equals(coordinate))
                .findAny()
                .orElse(null);
    }

    public List<Node> getAdjacentNodes(Coordinate coordinate) {
        return this.nodes.stream()
                .filter(node -> AstarUtils.isAdjacent(node.getCoordinate(), coordinate))
                .filter(node -> !node.getCondition().isBlock())
                .collect(Collectors.toList());
    }

    public void calculateHeuristic(Coordinate goal) {
        this.nodes
                .forEach(node -> node.setHeuristicCost(AstarUtils.calculateHeuristic(node.getCoordinate(), goal)));
    }
}