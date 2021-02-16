package ru.itmo.collection;

import ru.itmo.commands.Command;
import ru.itmo.fields.Flat;

import java.io.File;
import java.util.*;

public class MyCollection {
    private PriorityQueue<Flat> collection;
    private final File file;
    private final Date date;

    public MyCollection(String fileName) {
        collection = new PriorityQueue<>(new CollectionComparator());
        file = new File(fileName);
        date = new Date();
    }

    public PriorityQueue<Flat> getCollection() {
        return collection;
    }

    public void setCollection(PriorityQueue<Flat> collection) {
        this.collection = collection;
    }

    public PriorityQueue<Flat> sortCollectionByComp(Comparator<Flat> comp) {
        List<Flat> newList = new ArrayList<>(collection);
        newList.sort(comp);
        PriorityQueue<Flat> newCollection = new PriorityQueue<>(comp);
        newCollection.addAll(newList);
        return newCollection;
    }

    public void executeCommand(Command command, Scanner scanner, String[] args) {
        command.execute(this, scanner, args);
    }

    public File getFile() {
        return file;
    }

    public Date getDate() {
        return date;
    }


}
