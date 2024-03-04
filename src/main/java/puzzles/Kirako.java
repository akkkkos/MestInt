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

    public Kirako()
    {
        bal = new ArrayList<>();
        bal.add(Negyzet.A);
        bal.add(Negyzet.C);
        jobb = new ArrayList<>();
        jobb.add(Negyzet.B);
    }

    public Kirako(Kirako _k)
    {
        bal = new ArrayList<>(_k.bal);
        jobb = new ArrayList<>(_k.jobb);
    }
    public Kirako(Kirako _k, boolean _balrol, boolean _alulra)
    {
        super(_k);

        Kirako _tempKirako = new Kirako(_k);

        if (_balrol)
        {
            Negyzet _tempNegyzet = _tempKirako.bal.get(_tempKirako.bal.size()-1);
            _tempKirako.bal.remove(_tempKirako.bal.size()-1);
            if (!_alulra)
                _tempKirako.jobb.add(_tempNegyzet);
            else
                _tempKirako.jobb.add(0, _tempNegyzet);
        }
        else
        {
            Negyzet _tempNegyzet = _tempKirako.jobb.get(_tempKirako.jobb.size()-1);
            _tempKirako.jobb.remove(_tempKirako.jobb.size()-1);
            if (!_alulra)
                _tempKirako.bal.add(_tempNegyzet);
            else
                _tempKirako.bal.add(0, _tempNegyzet);
        }
        bal = new ArrayList<>(_tempKirako.bal);
        jobb = new ArrayList<>(_tempKirako.jobb);
    }

    @java.lang.Override
    public Iterable<State> getPossibleMoves() {
        Set<State> moves = new HashSet<State>();

        if (!bal.isEmpty())
        {
            moves.add(new Kirako(this, true, true));
            if (!jobb.isEmpty())
                moves.add(new Kirako(this, true, false));
        }
        if (!jobb.isEmpty())
        {
            moves.add(new Kirako(this, false, true));
            if (!bal.isEmpty())
                moves.add(new Kirako(this, false, false));
        }

        return moves;
    }

    @java.lang.Override
    public boolean isSolution() {
        if (jobb.size() != 3)
                return false;
        if (jobb.get(0).equals(Negyzet.C) &&
                jobb.get(1).equals(Negyzet.B) &&
                jobb.get(2).equals(Negyzet.A))
            return true;
        return false;
    }

    @java.lang.Override
    public double getHeuristic() {

        return 0;
        /*
        if (jobb.isEmpty())
            return 3;

        if (jobb.get(0) != Negyzet.C)
            return 2;

        if (jobb.size() > 1)
            if (jobb.get(1) != Negyzet.B)
                return 1;

        return 0;

         */
    }

    @Override
    public String toString() {
        String _temp = "\n";
        for (int i = 2; i >= 0; i--) {
            if (bal.size() > i)
                _temp += bal.get(i);
            else
                _temp += " ";

            if (jobb.size() > i)
                _temp += jobb.get(i);
            else
                _temp += " ";

            if (i != 0)
                _temp += "\n";
        }
        return _temp;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (o==null || !(o instanceof Kirako))
            return false;

        Kirako _kirako = (Kirako) o;

        if (_kirako.bal.size() != this.bal.size())
            return false;
        else
        {
            for (int i = 0; i < this.bal.size(); i++) {
                if (_kirako.bal.get(i) != this.bal.get(i))
                    return false;
            }
        }

        if (_kirako.jobb.size() != this.jobb.size())
            return false;
        else
        {
            for (int i = 0; i < this.jobb.size(); i++) {
                if (_kirako.jobb.get(i) != this.jobb.get(i))
                    return false;
            }
        }

        return true;
    }

     */
}
