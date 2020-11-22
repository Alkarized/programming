package itmo.ru.people;

import itmo.ru.abilities.IHear;
import itmo.ru.enums.Gender;
import itmo.ru.enums.HearType;
import itmo.ru.main.Main;

public class Carlson extends Characters implements IHear {
    public Carlson() {
        super("Карлосон", 33, Gender.MALE);
    }

}
