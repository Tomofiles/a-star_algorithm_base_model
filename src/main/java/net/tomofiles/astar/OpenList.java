package net.tomofiles.astar;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

public class OpenList {
    private final Queue<Node> openList;

    public OpenList() {
        this.openList = new PriorityQueue<Node>(Comparator.comparing(Node::getTotalCost));
    }

    public void push(Node node) {
        this.openList.removeIf(node::equals);
        this.openList.add(node);
    }

    public Node pull() {
        return this.openList.poll();
    }

    public boolean isEmpty() {
        return this.openList.isEmpty();
    }

    public boolean contains(Node node) {
        return this.openList.contains(node);
    }

    public Stream<Node> stream() {
        return this.openList.stream();
    }
}