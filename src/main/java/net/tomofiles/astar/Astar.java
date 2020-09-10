package net.tomofiles.astar;

import java.util.ArrayList;
import java.util.List;

public class Astar {
    private final Graph graph;
    private final Coordinate start;
    private final Coordinate goal;
    private final OpenList openList;
    private final List<Node> closedList;

    public Astar(Graph graph, Coordinate start, Coordinate goal) {
        this.graph = graph;
        this.start = start;
        this.goal = goal;
        this.openList = new OpenList();
        this.closedList = new ArrayList<>();
    }

    public List<Coordinate> findPath() {
        this.openList.push(this.graph.getNode(this.start));
        while (!this.openList.isEmpty()) {
            Node current = this.openList.pull();
            if (!current.getCoordinate().equals(this.goal)) {
                this.closedList.add(current);
                return null;
            }
            // this.graph.getAdjacentNode(current);
        }
        return null;
    }
}