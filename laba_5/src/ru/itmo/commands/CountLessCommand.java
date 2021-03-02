package ru.itmo.commands;

import ru.itmo.collection.MyCollection;
import ru.itmo.fields.Flat;
import ru.itmo.utils.Messages;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CountLessCommand extends Command {

    @Override
    public boolean execute(MyCollection myCollect, Scanner scanner, String[] args) {
        this.myCollection = myCollect;
        Integer number = 0;
        try {
            number = Integer.parseInt(args[1]);
            int count = 0;
            if (myCollection.getCollection().size() > 0) {
                PriorityQueue<Flat> priorityQueue = new PriorityQueue<Flat>(myCollection.getCollection());
                while (priorityQueue.size() > 0) {
                    if (Objects.requireNonNull(priorityQueue.poll()).getNumberOfRooms() < number)
                        count++;
                }
                Messages.normalMessageOutput("количество элементов, значение поля numberOfRooms которых меньше заданного - " + count);
                return true;
            } else {
                Messages.errorMessageOutput("В коллекции отсутствуют элементы!");
                return false;
            }
        } catch (Exception e) {
            Messages.errorMessageOutput("Неправильный ввод значения numberOfRooms");
            return false;
        }

    }
}
