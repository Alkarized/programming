package ru.itmo.abilities;

import ru.itmo.people.Human;

public interface Apologetic {
    //if not in the same room - exception!
    public void apologise(Human whom);
}
