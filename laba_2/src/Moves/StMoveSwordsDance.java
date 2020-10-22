package Moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class StMoveSwordsDance extends StatusMove {
    public StMoveSwordsDance() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected boolean checkAccuracy(Pokemon pokemon, Pokemon pokemon1) {
        return true;
    }

    @Override
    protected void applySelfEffects(Pokemon self) {
        self.setMod(Stat.ATTACK, 2);
    }

    @Override
    protected String describe() {
        return "танцуют все";
    }
}
