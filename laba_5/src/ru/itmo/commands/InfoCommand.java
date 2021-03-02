package ru.itmo.commands;

import ru.itmo.collection.MyCollection;
import ru.itmo.utils.Messages;

import java.util.Scanner;

public class InfoCommand extends Command {

    @Override
    public boolean execute(MyCollection myCollect, Scanner scanner, String[] args) {
        this.myCollection = myCollect;
        Messages.normalMessageOutput("Тип коллекции - " + myCollection.getCollection().getClass().getName() + "\n" +
                "Дата иницализации - " + myCollection.getDate() + "\n" +
                "Кол-во элементов - " + myCollection.getCollection().size());
        return true;
    }
}
