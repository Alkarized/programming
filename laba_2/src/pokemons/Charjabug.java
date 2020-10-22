package pokemons;

import Moves.SpMoveDischarge;
import ru.ifmo.se.pokemon.Type;

public class Charjabug extends Grubbin {
    public Charjabug(String name, int level) {
        super(name, level);
        addType(Type.ELECTRIC);
        setStats(57, 82, 95, 55, 75, 36);
        addMove(new SpMoveDischarge());
    }
}
