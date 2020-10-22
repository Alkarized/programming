package Moves;

import ru.ifmo.se.pokemon.*;

public class PhMoveFacade extends PhysicalMove {
    public PhMoveFacade() {
        super(Type.NORMAL, 70, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon opp, double damage) {
        Status pokCond = opp.getCondition();
        if(pokCond.equals(Status.BURN) || pokCond.equals(Status.POISON) || pokCond.equals(Status.PARALYZE)){
            opp.setMod(Stat.HP, (int) Math.round(damage)*2);
        } else{
            opp.setMod(Stat.HP, (int) Math.round(damage));
        }
    }

    @Override
    protected String describe() {
        return "Фасадит";
    }
}
