package net.tomofiles.astar;

public class PushOpenListCondition {
    public static boolean notContainsOpenAndClosedList(OpenList openList, ClosedList closedList, Node adjacentNode) {
        return !openList.contains(adjacentNode) && !closedList.contains(adjacentNode);
    }

    public static boolean containsOpenListAndCostIsLowerThanThat(OpenList openList, Node adjacentNode, int cost) {
        if (!openList.contains(adjacentNode)) return false;
        return openList.stream()
                .filter(adjacentNode::equals)
                .anyMatch(node -> node.getTotalCost() > cost);
    }

    public static boolean containsClosedListAndCostIsLowerThanThat(ClosedList closedList, Node adjacentNode, int cost) {
        if (!closedList.contains(adjacentNode)) return false;
        return closedList.stream()
                .filter(adjacentNode::equals)
                .anyMatch(node -> node.getTotalCost() > cost);
    }
}