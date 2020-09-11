package net.tomofiles.astar;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class HeuristicCost {
    private final int cost;

    private static final HeuristicCost INFINITY_HEURISTIC_COST = new HeuristicCost(Integer.MAX_VALUE);

    public static HeuristicCost newInfinity() {
        return INFINITY_HEURISTIC_COST;
    }

    public boolean isInfinity() {
        return this.cost == INFINITY_HEURISTIC_COST.cost;
    }
}