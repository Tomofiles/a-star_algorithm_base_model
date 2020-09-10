package net.tomofiles.astar;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Node {
    private final Coordinate coordinate;
    private final Condition condition;

    public int getF() {
        return 0;
    }
}