package Moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class SpMoveChargeBeam extends SpecialMove {
    public SpMoveChargeBeam() {
        super(Type.ELECTRIC, 50 ,90);
    }

    @Override
    protected void applySelfEffects(Pokemon self) {
        if(Math.random() <= 0.7){
            self.setMod(Stat.SPECIAL_ATTACK, 1);
        }
    }

    @Override
    protected String describe() {
        return "Пиу-Пиу";
    }
}
