package ru.itmo.commands;

import ru.itmo.collection.MyCollection;
import ru.itmo.utils.Messages;

import java.util.Scanner;

public class ExitCommand extends Command {

    @Override
    public boolean execute(MyCollection myCollect, Scanner scanner, String[] args) {
        this.myCollection = myCollect;
        Messages.normalMessageOutput("Выходим из программы, спасибо, что ВЫ есть ヽ(o＾▽＾o)ノ");
        System.exit(0);
        return true;
    }
}
