package ru.itmo.commands;

import ru.itmo.collection.Receiver;
import ru.itmo.utils.Messages;

import java.util.Scanner;

/**
 * Класс команды head
 */
public class HeadCommand extends Command {

    public HeadCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void printInfoAboutCommand() {
        System.out.println("head : вывести первый элемент коллекции");
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 1){
            if(!receiver.getHead()){
               Messages.errorMessageOutput("Так коллекция пустая, куда тебе что-то выводить!");
            }
        } else {
            Messages.errorMessageOutput("Неправильный ввод аргументов, жду по новому все");
        }
    }

    @Override
    public void execute(String[] args, Scanner scanner) {
        this.execute(args);
    }
}
