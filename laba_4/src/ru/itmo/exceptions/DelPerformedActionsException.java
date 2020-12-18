package ru.itmo.exceptions;

//Runtime excp bad name!
public class DelPerformedActionsException extends RuntimeException{
    public DelPerformedActionsException(){
        super("Отличаня попытка, но у тебя ничего не поулчиться, ведь прошлого уже не вернуть, такова реальность!");
    }
}
