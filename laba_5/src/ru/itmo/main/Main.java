package ru.itmo.main;

import com.opencsv.CSVReader;
import ru.itmo.collection.CollectionManager;
import ru.itmo.utils.CSVFileReader;
import ru.itmo.utils.CSVParser;
import ru.itmo.utils.ProgramStarter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alkarized
 * @version 1.0
 * Основной класс моей программы
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

