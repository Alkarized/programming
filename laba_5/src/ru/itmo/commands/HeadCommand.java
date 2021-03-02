package ru.itmo.commands;

import ru.itmo.collection.MyCollection;
import ru.itmo.utils.Messages;

import java.util.Objects;
import java.util.Scanner;

public class HeadCommand extends Command {

    @Override
    public boolean execute(MyCollection myCollect, Scanner scanner, String[] args) {
        this.myCollection = myCollect;
        if (myCollection.getCollection().size() > 0){
            Objects.requireNonNull(myCollection.getCollection().peek()).printInfoAboutElement();
            return true;
        } else {
            Messages.errorMessageOutput("В коллекции отсутствуют элементы!");
            return false;
        }
    }
}
