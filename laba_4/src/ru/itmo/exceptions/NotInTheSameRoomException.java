package ru.itmo.exceptions;

import ru.itmo.people.Human;

public class NotInTheSameRoomException extends Exception{
    public NotInTheSameRoomException(Human who, String whatToDo, Human toWhom){
        super(who.getName() + " находится в другой команте и не может " + whatToDo + " " + toWhom.getName());
    }
}
