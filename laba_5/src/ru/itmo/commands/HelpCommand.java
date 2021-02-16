package ru.itmo.commands;

import ru.itmo.collection.MyCollection;

import java.util.Scanner;

public class HelpCommand extends Command {

    @Override
    public boolean execute(MyCollection myCollect, Scanner scanner, String[] args) {
        this.myCollection = myCollect;
        System.out.println("");
        System.out.println("Доступные команды для работы:");
        System.out.println("");
        System.out.println("help : вывести справку по доступным командам");
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("add {element} : добавить новый элемент в коллекцию");
        System.out.println("update id {element} : обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_by_id id : удалить элемент из коллекции по его id");
        System.out.println("clear : очистить коллекцию");
        System.out.println("save : сохранить коллекцию в файл");
        System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        System.out.println("exit : завершить программу (без сохранения в файл)");
        System.out.println("remove_first : удалить первый элемент из коллекции");
        System.out.println("head : вывести первый элемент коллекции");
        System.out.println("remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный");
        System.out.println("min_by_coordinates : вывести любой объект из коллекции, значение поля coordinates которого является минимальным");
        System.out.println("count_less_than_number_of_rooms numberOfRooms : вывести количество элементов, значение поля numberOfRooms которых меньше заданного");
        System.out.println("print_field_descending_number_of_rooms : вывести значения поля numberOfRooms всех элементов в порядке убывания");
        System.out.println("");
        return true;
    }
}
