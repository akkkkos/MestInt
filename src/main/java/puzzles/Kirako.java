package puzzles;

import search.AbstractState;
import search.State;

public class Kirako extends AbstractState {
    @java.lang.Override
    public Iterable<State> getPossibleMoves() {
        return null;
    }

    @java.lang.Override
    public boolean isSolution() {
        return false;
    }

    @java.lang.Override
    public double getHeuristic() {
        return 0;
    }
}
