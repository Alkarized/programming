package pokemons;

import Moves.SpMoveFlashCannon;
import Moves.SpMoveThunderbolt;
import Moves.StMoveHarden;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Ferroseed extends Pokemon {
    public Ferroseed(String name, int level) {
        super(name, level);
        setType(Type.GRASS, Type.STEEL);
        setStats(44, 50, 91, 24, 86, 10);
        setMove(new SpMoveThunderbolt(), new StMoveHarden(), new SpMoveFlashCannon());
    }
}
