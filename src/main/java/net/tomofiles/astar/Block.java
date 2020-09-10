package net.tomofiles.astar;

import java.util.ArrayList;
import java.util.List;

public class Block {
    private final List<Coordinate> coordinates;

    public Block(List<Coordinate> coordinates) {
        this.coordinates = new ArrayList<>(coordinates);
    }

    public boolean includes(Coordinate coordinate) {
        return true;
    }
}