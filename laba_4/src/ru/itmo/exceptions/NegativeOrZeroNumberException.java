package ru.itmo.exceptions;

public class NegativeOrZeroNumberException extends RuntimeException{
    public NegativeOrZeroNumberException(){
        super("Получили негативное число или ноль, которые не должно быть тут");
    }
}
