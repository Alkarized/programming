package ru.itmo.abilities;

import ru.itmo.enums.Instructions;
import ru.itmo.exceptions.NotInTheSameRoomException;
import ru.itmo.people.Julius;
import ru.itmo.people.Observers;

public interface Instructing {
    //if not in the same room - exception!
    public void instructJulius(Instructions instruction, Julius who, Observers observers) throws NotInTheSameRoomException;
}
