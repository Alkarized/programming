package pokemons;

import Moves.PhMoveFacade;
import Moves.SpMoveChargeBeam;
import Moves.SpMoveDreamEater;
import Moves.SpMoveThunder;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Giratina extends Pokemon {

    public Giratina(String name, int level) {
        super(name, level);
        setType(Type.GHOST, Type.DRAGON);
        setStats(150, 100, 120, 100, 120, 90);
        setMove(new SpMoveChargeBeam(), new SpMoveThunder(), new SpMoveDreamEater(), new PhMoveFacade());
    }
}
