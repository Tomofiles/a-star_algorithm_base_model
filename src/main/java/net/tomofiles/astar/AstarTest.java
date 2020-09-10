package net.tomofiles.astar;

import java.util.Arrays;
import java.util.List;

public class AstarTest {
    public static void main(String[] args) {
        List<Block> blocks = Arrays.asList(new Block[] {
            new Block(Arrays.asList(new Coordinate[] {
                new Coordinate(1, 3),
                new Coordinate(2, 3),
                new Coordinate(3, 3)
            }))
        });
        Graph graph = new Graph(6, 7, blocks);
        Coordinate start = new Coordinate(2, 1);
        Coordinate goal = new Coordinate(2, 5);

        Astar aStar = new Astar(graph, start, goal);

        List<Coordinate> path = aStar.findPath();

        path.forEach(System.out::println);
    }
}