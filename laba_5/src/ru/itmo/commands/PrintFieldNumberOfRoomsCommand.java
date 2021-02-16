package ru.itmo.commands;

import ru.itmo.collection.MyCollection;
import ru.itmo.fields.Flat;
import ru.itmo.utils.Messages;

import java.util.*;

public class PrintFieldNumberOfRoomsCommand extends Command {

    @Override
    public boolean execute(MyCollection myCollect, Scanner scanner, String[] args) {
        this.myCollection = myCollect;
        if (myCollection.getCollection().size() > 0) {
            List<Flat> list = new ArrayList<Flat>(myCollection.getCollection());
            list.sort(new Comparator<Flat>() {
                @Override
                public int compare(Flat o1, Flat o2) {
                    return o2.getNumberOfRooms().compareTo(o1.getNumberOfRooms());
                }
            });
            Messages.normalMessageOutput("значения поля numberOfRooms всех элементов в порядке убывания:");
            for (Flat flat : list) {
                System.out.print(flat.getNumberOfRooms() + " ");
            }
            System.out.println("");
            return true;
        } else {
            Messages.errorMessageOutput("В коллекции отсутствуют элементы!");
            return false;
        }

    }
}
