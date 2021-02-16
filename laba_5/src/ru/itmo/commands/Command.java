package ru.itmo.commands;

import ru.itmo.collection.MyCollection;

import java.util.Scanner;

public abstract class Command {
    public MyCollection myCollection;

    public abstract boolean execute(MyCollection myCollect, Scanner scanner, String[] args);
}
