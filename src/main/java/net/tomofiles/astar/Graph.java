package net.tomofiles.astar;

import java.util.List;

public class Graph {
    private static final int DEFAULT_COST = 1;

    private final Node[][] nodes;

    public Graph(int rows, int cols, List<Block> blocks) {
        this.nodes = initNodes(rows, cols, blocks);
    }

    private static Node[][] initNodes(int rows, int cols, List<Block> blocks) {
        Node[][] nodes = new Node[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Coordinate coordinate = new Coordinate(row, col);
                if (blocks.stream().anyMatch(block -> block.includes(coordinate))) {
                    nodes[row][col] = new Node(coordinate, Condition.newBlockCondition(DEFAULT_COST));
                } else {
                    nodes[row][col] = new Node(coordinate, Condition.newCondition(DEFAULT_COST));
                }
            }
        }
        return nodes;
    }

    public Node getNode(Coordinate coordinate) {
        return this.nodes[coordinate.getRow()][coordinate.getCol()];
    }
}