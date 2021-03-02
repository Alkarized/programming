package ru.itmo.commands;

import ru.itmo.collection.MyCollection;
import ru.itmo.fields.Flat;
import ru.itmo.utils.FlatMaker;
import ru.itmo.utils.Messages;

import java.util.Scanner;

public class RemoveLowerCommand extends Command {

    @Override
    public boolean execute(MyCollection myCollect, Scanner scanner, String[] args) {
        this.myCollection = myCollect;
        FlatMaker flatMaker = new FlatMaker();
        Flat flat = new Flat();
        if(myCollect.getCollection().size() == 0){
            Messages.errorMessageOutput("А в коллекции-то нет эллементов, куда лезешь?");
            return false;
        }
        if(flatMaker.makeNewFlat(flat, args[1], scanner)) {
            myCollection.getCollection().add(flat);
            while (!myCollection.getCollection().equals(flat)){
                Long id = myCollect.getCollection().peek().getId();
                myCollection.getCollection().poll().removeUsedId(id);
            }
            myCollection.getCollection().poll();
            Messages.normalMessageOutput("Элементы коллекции, меньше данного удалены!");
            myCollection.getCollection().add(flat);
            return true;
        } else {
            return false;
        }
    }
}
