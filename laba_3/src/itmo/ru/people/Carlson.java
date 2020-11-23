package itmo.ru.people;

import itmo.ru.abilities.IHear;
import itmo.ru.enums.Gender;

public class Carlson extends Listeners implements IHear {
    public Carlson() {
        super("Карлосон", 33, Gender.MALE);
    }

}
