package ru.itmo.commands;

import ru.itmo.collection.MyCollection;
import ru.itmo.utils.Messages;

import java.util.Scanner;

public class RemoveFirstCommand extends Command {

    @Override
    public boolean execute(MyCollection myCollect, Scanner scanner, String[] args) {
        this.myCollection = myCollect;
        if (myCollection.getCollection().size() > 0) {
            Long id = myCollect.getCollection().peek().getId();
            myCollection.getCollection().poll().removeUsedId(id);
            Messages.normalMessageOutput("Первый элемент из коллекции удален!");
            return true;
        } else {
            Messages.errorMessageOutput("В коллекции отсутствуют элементы!");
            return false;
        }

    }
}
