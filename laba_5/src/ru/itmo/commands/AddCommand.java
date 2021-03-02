package ru.itmo.commands;

import ru.itmo.collection.MyCollection;
import ru.itmo.fields.*;
import ru.itmo.utils.FlatMaker;
import ru.itmo.utils.Messages;

import java.util.Scanner;

public class AddCommand extends Command {

    @Override
    public boolean execute(MyCollection myCollect, Scanner scanner, String[] args) {
        this.myCollection = myCollect;
        Flat flat = new Flat();
        FlatMaker flatMaker = new FlatMaker();
        if(flatMaker.makeNewFlat(flat, args[1], scanner)) {
            flat.setId((long) Math.floor(Math.random() * 999999998) + 1);
            Messages.normalMessageOutput("Новый элемент добавлен в коллекцию, УРА!");
            myCollection.getCollection().add(flat);
            return true;
        } else {
            return false;
        }

    }
}
