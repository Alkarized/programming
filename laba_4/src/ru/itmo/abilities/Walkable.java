package ru.itmo.abilities;

import ru.itmo.people.Human;

public interface Walkable {
    public void needToWalkTo(String where);
    public void goAwayFromHome(boolean isManaged);
    public void backHome(String from);
    public void walkToHuman(Human human);
}
