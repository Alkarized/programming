package Moves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class SpMoveThunderbolt extends SpecialMove {
    public SpMoveThunderbolt() {
        super(Type.ELECTRIC, 90, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon opp) {
        if(Math.random() <= 0.1){
            Effect.paralyze(opp);
        }
    }

    @Override
    protected String describe() {
        return "БАБАХ";
    }
}
