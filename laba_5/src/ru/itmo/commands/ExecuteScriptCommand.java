package ru.itmo.commands;

import ru.itmo.collection.MyCollection;
import ru.itmo.utils.LineReader;
import ru.itmo.utils.Messages;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExecuteScriptCommand extends Command{

    @Override
    public boolean execute(MyCollection myCollect, Scanner scanner, String[] args) {
        this.myCollection = myCollect;
        LineReader lineReader = new LineReader(myCollection);
        try {
            lineReader.reader(new Scanner(new File(args[1])));
            Messages.normalMessageOutput("Все команды выполнились, переходим обратно к терминалу");
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Messages.errorMessageOutput("Файл не найден, попробуйте ввести команду еще раз");
            return false;
        }

    }
}
