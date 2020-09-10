package net.tomofiles.astar;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Condition {
    private final int cost;
    private final boolean isBlock;

    public static Condition newBlockCondition(int cost) {
        return new Condition(cost, true);
    }

    public static Condition newCondition(int cost) {
        return new Condition(cost, false);
    }
}