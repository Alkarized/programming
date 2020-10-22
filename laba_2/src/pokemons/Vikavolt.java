package pokemons;

import Moves.SpMoveBugBuzz;

public class Vikavolt extends Charjabug {
    public Vikavolt(String name, int level) {
        super(name, level);
        setStats(77, 70, 90, 145, 75, 43);
        addMove(new SpMoveBugBuzz());

    }
}
