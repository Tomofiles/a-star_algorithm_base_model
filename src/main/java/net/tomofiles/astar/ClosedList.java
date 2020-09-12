package net.tomofiles.astar;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ClosedList {
    private final Set<Node> closedList;

    public ClosedList() {
        this.closedList = new HashSet<>();
    }

    public void push(Node node) {
        this.closedList.add(node);
    }

    public boolean contains(Node node) {
        return this.closedList.contains(node);
    }

    public Stream<Node> stream() {
        return this.closedList.stream();
    }
}