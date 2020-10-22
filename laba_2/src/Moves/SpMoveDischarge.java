package Moves;

import ru.ifmo.se.pokemon.*;

public class SpMoveDischarge extends SpecialMove {
    public SpMoveDischarge() {
        super(Type.ELECTRIC, 80, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon opp) {
        Effect e = new Effect();
        e.chance(0.3);
        e.condition(Status.PARALYZE);
        opp.addEffect(e);
    }

    @Override
    protected String describe() {
        return "Кхья";
    }
}
