package net.tomofiles.astar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ClosedList {
    private final List<Node> closedList;

    public ClosedList() {
        this.closedList = new ArrayList<>();
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