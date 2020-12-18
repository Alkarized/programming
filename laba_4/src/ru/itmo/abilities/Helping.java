package ru.itmo.abilities;

import ru.itmo.enums.HelpType;
import ru.itmo.exceptions.NotInTheSameRoomException;
import ru.itmo.people.Human;

public interface Helping {
    //if not in the same room - exception!
    public void helpToWith(Human toHuman, HelpType helpType) throws NotInTheSameRoomException;
}
