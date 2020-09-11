package net.tomofiles.astar;

public class AstarUtils {
    public static boolean isAdjacent(Coordinate coordinateA, Coordinate coordinateB) {
        int rowDistance = Math.abs(coordinateA.getRow() - coordinateB.getRow());
        int colDistance = Math.abs(coordinateA.getCol() - coordinateB.getCol());
        int sumDistance = rowDistance + colDistance;
        
        if ((sumDistance == 1) || (rowDistance == 1 && colDistance == 1)) {
            return true;
        }
        return false;
    }

    public static int calculateCost(Node current, Node adjacent) {
        return adjacent.getCondition().getCost() + adjacent.getHeuristicCost().getCost() + current.getTotalCost();
    }

    public static HeuristicCost calculateHeuristic(Coordinate each, Coordinate goal) {
        int heuristic = Math.abs(goal.getRow() - each.getRow())
                + Math.abs(goal.getCol() - each.getCol());
        return new HeuristicCost(heuristic);
    }

}