package Moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class SpMoveFlashCannon extends SpecialMove {
    public SpMoveFlashCannon() {
        super(Type.STEEL, 80, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon opp) {
        if(Math.random() <= 0.1){
            opp.setMod(Stat.SPECIAL_DEFENSE, -1);
        }
    }

    @Override
    protected String describe() {
        return "FLAAASH";
    }
}
