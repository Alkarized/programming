package Moves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class PhMoveBite extends PhysicalMove {
    public PhMoveBite() {
        super(Type.DARK, 60, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon opp) {
        if(Math.random() <= 0.3d ){
            Effect.flinch(opp);
        }
    }

    @Override
    protected String describe() {
        return "Кусь";
    }
}
