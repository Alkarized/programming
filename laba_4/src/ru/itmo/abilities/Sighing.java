package ru.itmo.abilities;

import ru.itmo.people.Human;

@FunctionalInterface
public interface Sighing {
    public void sigh(Human who);
}
