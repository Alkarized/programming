package ru.itmo.commands;

import ru.itmo.collection.CollectionComparator;
import ru.itmo.collection.MyCollection;
import ru.itmo.fields.Flat;
import ru.itmo.utils.Messages;

import java.util.PriorityQueue;
import java.util.Scanner;

public class ShowCommand extends Command {

    @Override
    public boolean execute(MyCollection myCollect, Scanner scanner, String[] args) {
        this.myCollection = myCollect;
        if (myCollection.getCollection().size() > 0) {
            PriorityQueue<Flat> list = myCollection.sortCollectionByComp(new CollectionComparator());
            for (Flat flat : list) {
                flat.printInfoAboutElement();
            }
            return true;
        } else {
            Messages.errorMessageOutput("Коллекция пустая, нечего выводить(");
            return false;
        }
    }
}
