package itmo.ru.people;

import itmo.ru.abilities.IWalk;
import itmo.ru.enums.Gender;

public class Julius extends AHuman implements IWalk {
    public Julius() {
        setName("Юлиус");
        setAge(45);
        setGender(Gender.MALE);
    }


    @Override
    public void walkAway(boolean isManagedWalkAway) {
        if (isManagedWalkAway)
            System.out.println(getName() + " ушёл");
        else
            System.out.println(getName() + " не успел уйти, как");
    }
}
