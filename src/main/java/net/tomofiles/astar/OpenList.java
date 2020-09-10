package net.tomofiles.astar;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class OpenList {
    private final Queue<Node> openList;

    public OpenList() {
        this.openList = new PriorityQueue<Node>(Comparator.comparing(Node::getF));
    }

    public void push(Node node) {
        this.openList.add(node);
    }

    public Node pull() {
        return this.openList.poll();
    }

    public boolean isEmpty() {
        return this.openList.isEmpty();
    }
}