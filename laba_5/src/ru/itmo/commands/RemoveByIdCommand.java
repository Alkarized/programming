package ru.itmo.commands;

import ru.itmo.collection.MyCollection;
import ru.itmo.fields.Flat;
import ru.itmo.utils.Messages;

import java.util.Scanner;

public class RemoveByIdCommand extends Command {

    @Override
    public boolean execute(MyCollection myCollect, Scanner scanner, String[] args) {
        this.myCollection = myCollect;
        Flat removeObj = null;
        Long id = Long.valueOf(args[1]);
        for (Flat flat : myCollection.getCollection())
            if (flat.getId().equals(id)) {
                removeObj = flat;
                flat.removeUsedId(id);
                break;
            }

        if (removeObj != null) {
            myCollection.getCollection().remove(removeObj);
            System.out.println("Элемент с таким id - " + id + " был успешно удален");
        } else {
            Messages.errorMessageOutput("В коллекции нет элемента с таким id - " + id);
        }
        return false;
    }
}
