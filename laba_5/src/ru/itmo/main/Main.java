package ru.itmo.main;

import ru.itmo.collection.CollectionManager;
import ru.itmo.utils.CSVFileReader;
import ru.itmo.utils.ProgramStarter;

/**
 * Основной класс моей программы
 * @author Alkarized
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        /*String[] test = new String[1];
        test[0] = "name";
        CollectionManager collectionManager = new CollectionManager(new CSVFileReader().getFileNameFromArgs(test));*/
        CollectionManager collectionManager = new CollectionManager(new CSVFileReader().getFileNameFromArgs(args));

        ProgramStarter programStarter = new ProgramStarter(collectionManager);
        programStarter.start();
    }

}

