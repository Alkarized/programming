package ru.itmo.utils;

import ru.itmo.collection.Invoker;

import java.util.Scanner;

/**
 * Класс, которые реализует считывание из командной строки / файла
 */
public class LineReader {

    /**
     * Считываение из командной строки / файла
     * @param scanner показывает откуда считывать информацию
     * @param invoker необходим для реальизации вызова всех команд
     */
    public void readLine(Scanner scanner, Invoker invoker) {
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] args = line.trim().split(" ");
            if (args.length != 0){
                invoker.executeCommand(scanner, args);
            }
        }
    }

}
