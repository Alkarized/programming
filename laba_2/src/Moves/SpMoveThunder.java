package Moves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class SpMoveThunder extends SpecialMove {
    public SpMoveThunder() {
        super(Type.ELECTRIC, 110, 70);
    }

    @Override
    protected void applyOppEffects(Pokemon opp) {
        if(Math.random() <= 0.3){
            Effect.paralyze(opp);
        }
    }

    @Override
    protected String describe() {
        return "Скидыщь";
    }
}
