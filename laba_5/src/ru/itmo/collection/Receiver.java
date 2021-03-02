package ru.itmo.collection;

import ru.itmo.fields.Flat;
import ru.itmo.utils.CSVParser;
import ru.itmo.utils.LineReader;
import ru.itmo.utils.Messages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Класс ресивер (получатель), в котором описана логика некоторых команд
 */
public class Receiver {
    private final CollectionManager collectionManager;
    private final Invoker invoker;

    /**
     * Конструктор
     * @param collectionManager добалвяет менеджер коллекции
     * @param invoker добавляет исполнителя
     */
    public Receiver(CollectionManager collectionManager, Invoker invoker) {
        this.collectionManager = collectionManager;
        this.invoker = invoker;
    }

    /**
     * выводит информацию о всех командах
     */
    public void getInfoAboutAllCommands() {
        invoker.getHashMap().forEach((name, command) -> command.printInfoAboutCommand());
    }

    /**
     * Логика для info
     */
    public void getInfoAboutCollection() {
        collectionManager.printInfoAboutCollection();
    }

    /**
     * Логика для exit
     */
    public void exit() {
        System.exit(0);
    }

    /**
     * Логика для clear
     */
    public boolean clear() {
        return collectionManager.clearCollection();
    }

    /**
     * Логика для head
     */
    public boolean getHead() {
        return collectionManager.getHeadOfCollection();
    }

    /**
     * Логика для count_less_than_number_of_rooms
     */
    public int countLessNumberOfRooms(int number) {
        return collectionManager.countLessNumberOfRooms(number);
    }

    /**
     * Логика для min_by_coordinates
     */
    public boolean printElementWithMinCoordinates() {
        return collectionManager.findElementWithMinCoordinates();
    }

    /**
     * Логика для print_field_descending_number_of_rooms
     */
    public boolean printFieldDescendingNumberOfRooms() {
        return collectionManager.printFieldDescendingNumberOfRooms();
    }

    /**
     * Логика для remove_by_id
     */
    public boolean removeById(Long id) {
        return collectionManager.removeElementById(id);
    }

    /**
     * Логика для remove_first
     */
    public boolean removeFirst() {
        return collectionManager.removeFirstElement();
    }

    /**
     * Реализация команды save
     */
    public boolean saveCollection() throws FileNotFoundException {
        if(collectionManager.getCollection().size() > 0){
            CSVParser csvParser = new CSVParser();
            PrintWriter printWriter = new PrintWriter(collectionManager.getFile());
            for (Flat flat : collectionManager.getCollection()) {
                printWriter.println(csvParser.makeCSVLineFromFlat(flat));
                printWriter.flush();
            }
            printWriter.close();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Логика для show
     */
    public boolean printAllElements(){
        return collectionManager.printAllElements();
    }

    /**
     * Логика для add
     */
    public boolean addElement(String arg, Scanner scanner){
        return collectionManager.addElement(arg, scanner);
    }

    /**
     * Логика для update
     */
    public boolean updateElementById(Long id, String arg, Scanner scanner){
        return collectionManager.updateElement(id, arg, scanner);
    }

    /**
     * Логика для remove_lower
     */
    public boolean removeLowerElements(String arg, Scanner scanner){
        return collectionManager.removeLower(arg, scanner);
    }

    /**
     * Логика для execute_script
     */
    public boolean executeScript(String args){
        LineReader lineReader = new LineReader();
        File file = null;
        try {
            file = new File(args);
            if(!file.exists()||!file.canRead()||!file.canWrite()){
                throw new IllegalAccessError();
            }
            lineReader.readLine(new Scanner(file), invoker);
        } catch (IllegalAccessError | FileNotFoundException e){
            Messages.errorMessageOutput("Невозможно работать с данным файлом, попробуйте еще раз");
            return false;
        } catch (StackOverflowError | OutOfMemoryError e) {
            Messages.errorMessageOutput("ЭЭЭЭЭ, куда, рекурся зло, вышел и зашел обратно!");
            return false;
        }
        Messages.normalMessageOutput("Закончилось выполнение скрипта из файла");
        return true;
    }
}
