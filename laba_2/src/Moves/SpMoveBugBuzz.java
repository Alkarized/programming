package Moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class SpMoveBugBuzz extends SpecialMove {
    public SpMoveBugBuzz() {
        super(Type.BUG, 90, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon opp) {
        if(Math.random() <= 0.10){
            opp.setMod(Stat.SPECIAL_DEFENSE, -1);
        }
    }

    @Override
    protected String describe() {
        return "ЖЖЖужЖЖАние";
    }
}
