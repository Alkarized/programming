package ru.itmo.commands;

import ru.itmo.collection.MyCollection;
import ru.itmo.fields.Flat;
import ru.itmo.utils.Messages;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinByCoordinatesCommand extends Command {

    @Override
    public boolean execute(MyCollection myCollect, Scanner scanner, String[] args) {
        this.myCollection = myCollect;
        if (myCollection.getCollection().size() > 0) {
            PriorityQueue<Flat> list = myCollection.sortCollectionByComp(new Comparator<Flat>() {
                @Override
                public int compare(Flat o1, Flat o2) {
                    return o1.getCoordinates().getX().compareTo(o2.getCoordinates().getX()) +
                            o1.getCoordinates().getY().compareTo(o2.getCoordinates().getY());
                }
            });

            if (list.peek() != null) {
                list.peek().printInfoAboutElement();
            }
            return true;
        } else {
            Messages.errorMessageOutput("В коллекции отсутствуют элементы!");
            return false;
        }
    }
}
