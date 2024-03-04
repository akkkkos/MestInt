package puzzles;

import search.AbstractState;
import search.State;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

enum Negyzet {A, B, C};
public class Kirako extends AbstractState {

    ArrayList<Negyzet> bal;
    ArrayList<Negyzet> jobb;
    public Kirako(Kirako _k, boolean _balrol, boolean _alulra)
    {
        super(_k);

    }
    @java.lang.Override
    public Iterable<State> getPossibleMoves() {
        Set<State> moves = new HashSet<State>();

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
