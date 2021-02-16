package ru.itmo.commands;

import ru.itmo.collection.CollectionComparator;
import ru.itmo.collection.MyCollection;
import ru.itmo.fields.Flat;
import ru.itmo.utils.Messages;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ClearCommand extends Command {

    @Override
    public boolean execute(MyCollection myCollect, Scanner scanner, String[] args) {
        this.myCollection = myCollect;
        if (myCollection.getCollection().size() > 0) {
            Flat.clearSet();
            myCollection.getCollection().clear();
            Messages.normalMessageOutput("Коллекция успешно очистина!");
            return true;
        } else {
            Messages.errorMessageOutput("Коллекция пустая, нечего чистить");
            return false;
        }
    }
}
