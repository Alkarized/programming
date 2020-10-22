package Moves;

import ru.ifmo.se.pokemon.*;

public class SpMoveDreamEater extends SpecialMove {
    private int drained_HP = 0;

    public SpMoveDreamEater() {
        super(Type.PSYCHIC, 100, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon opp, double damage) {
        Status oppStatus = opp.getCondition();
        if(oppStatus.equals(Status.SLEEP)){
            drained_HP = -1*(int)(Math.round(damage)/2);
            opp.setMod(Stat.HP, (int)Math.round(damage));
        }
    }

    @Override
    protected void applySelfEffects(Pokemon self) {
        self.setMod(Stat.HP, drained_HP);
    }

    @Override
    protected String describe() {
        return "-дрим";
    }
}
