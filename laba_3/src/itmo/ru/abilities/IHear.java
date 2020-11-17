package itmo.ru.abilities;

import itmo.ru.enumobjs.HearType;
import itmo.ru.people.AHuman;

public interface IHear {
    public void hear(AHuman who, HearType what, boolean isBySelf);
}
