package ru.itmo.main;

import ru.itmo.collection.MyCollection;
import ru.itmo.fields.Furnish;
import ru.itmo.utils.CSVParser;
import ru.itmo.utils.FileReader;
import ru.itmo.utils.LineReader;
import ru.itmo.utils.Messages;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader();
        MyCollection myCollection = new MyCollection(fileReader.getFileNameFromArgs(args));
        fileReader.readFile(myCollection);

        LineReader lineReader = new LineReader(myCollection);
        lineReader.reader(new Scanner(System.in));


    }
}
