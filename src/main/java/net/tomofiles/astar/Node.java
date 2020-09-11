package net.tomofiles.astar;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"coordinate"})
public class Node {
    private final Coordinate coordinate;
    private final Condition condition;
    private HeuristicCost heuristicCost = HeuristicCost.newInfinity();
    private int totalCost = 0;
    private Node parent = null;
}