package ru.itmo.utils;

/**
 * Класс для вывода информации в командную строку
 */
public class Messages {
    /**
     * Выводит на экран сообщение, которое говорит о каких-то действиях программы
     * @param message сообщение которые выведется на экран
     */
    public static void normalMessageOutput(String message){
        System.out.println("");
        System.out.println(message);
        System.out.println("");
    }

    /**
     * Выводит сообщения об ошибках программы
     * @param message сообщение об ошибке
     */
    public static void errorMessageOutput(String message){
        System.err.println("");
        System.err.println(message);
        System.err.println("");
    }
}