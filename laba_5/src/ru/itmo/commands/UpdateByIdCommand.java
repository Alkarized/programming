package ru.itmo.commands;

import ru.itmo.collection.MyCollection;
import ru.itmo.fields.Flat;
import ru.itmo.utils.FlatMaker;
import ru.itmo.utils.Messages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.PriorityQueue;
import java.util.Scanner;

public class UpdateByIdCommand extends Command {

    @Override
    public boolean execute(MyCollection myCollect, Scanner scanner, String[] args) {
        this.myCollection = myCollect;
        Long ids = 0L;
        try {
            ids = Long.valueOf(args[1]);
            if(ids <= 0) throw new Exception();
            if(!new Flat().checkIdUniq(ids)) throw new Exception();
        } catch (Exception e){
            Messages.errorMessageOutput("Нерпавильный ввод id, либо такого id нет");
            return false;
        }
        if(myCollect.getCollection().size() == 0){
            Messages.errorMessageOutput("А в коллекции-то нет эллементов, куда лезешь?");
            return false;
        }

        Flat flat = new Flat();
        FlatMaker flatMaker = new FlatMaker();
        if(flatMaker.makeNewFlat(flat,args[2], scanner)){
            PriorityQueue<Flat> queue = new PriorityQueue<>();
            while (!myCollection.getCollection().peek().getId().equals(ids)){
                queue.add(myCollection.getCollection().poll());
            }

            try {
                flat.setCreationDate(new SimpleDateFormat("yyyy-MM-dd;HH:mm:ss.SSS").parse(myCollection.getCollection().poll().getCreationDate()));
            } catch (ParseException e) {
                Messages.errorMessageOutput("Какая-то проблема с датой ?");
                return false;
            }
            flat.setId(ids);

            myCollect.getCollection().add(flat);
            while (queue.size() > 0){
                myCollect.getCollection().add(queue.poll());
            }
            myCollection.getCollection().poll();
            Messages.normalMessageOutput("Элемент обновлен, ВОЗРАДУЙСЯ СМЕРТНЫЙ!!!");
            return true;
        } else {
            return false;
        }

    }
}
