package pokemons;

import Moves.StMoveSwordsDance;

public class Ferrothorn extends Ferroseed {
    public Ferrothorn(String name, int level) {
        super(name, level);
        setStats(74, 94, 131, 54, 116, 20);
        addMove(new StMoveSwordsDance());
    }
}
