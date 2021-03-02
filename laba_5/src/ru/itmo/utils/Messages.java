package ru.itmo.utils;

public class Messages {
    public static void normalMessageOutput(String message){
        System.out.println("");
        System.out.println(message);
        System.out.println("");
    }

    public static void errorMessageOutput(String message){
        System.err.println("");
        System.err.println(message);
        System.err.println("");
    }
}

//Messages.errorMessageOutput("Неверный ввод команды, попробуйте еще раз или напишите help для вывода доступных команд");
