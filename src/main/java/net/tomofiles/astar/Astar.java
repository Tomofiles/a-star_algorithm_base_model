package net.tomofiles.astar;

import java.util.List;

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
        return FindPathAlgorithm.execute(
                this.graph,
                this.start,
                this.goal,
                this.openList,
                this.closedList);
    }
}