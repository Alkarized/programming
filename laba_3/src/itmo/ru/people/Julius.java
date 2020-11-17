package itmo.ru.people;

import itmo.ru.abilities.IWalkAway;
import itmo.ru.enumobjs.Gender;

public class Julius extends AHuman implements IWalkAway {
    @Override
    public void walkAway(boolean isManaged) {
        if (isManaged)
            System.out.println(getName() + " ушёл");
        else
            System.out.println(getName() + " не успел уйти, как");
    }

    public Julius() {
        setGender(Gender.MALE);
        setName("Юлиус");
    }
}
