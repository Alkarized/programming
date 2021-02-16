package ru.itmo.utils;

import ru.itmo.collection.MyCollection;
import ru.itmo.commands.*;

import java.util.ArrayList;
import java.util.Scanner;

public class LineReader {

    private final MyCollection myCollection;

    public LineReader(MyCollection myCollection) {
        this.myCollection = myCollection;
    }

    public void reader(Scanner sc) {
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] strings = str.split(" ");
            ArrayList<String> list = new ArrayList<>();
            for (String st : strings) {
                if (!st.equals("")) {
                    list.add(st);
                }
            }

            if (list.size() != 0) {
                if (list.get(0).equals("add")) {
                    if (list.size() == 2) {
                        myCollection.executeCommand(new AddCommand(), sc, list.toArray(new String[0]));
                    } else {
                        Messages.errorMessageOutput("Что-то пошло не так, какие-то неправильные у тебя аргументы, " +
                                "ты должен подать значения полей элемента в таком порядке: " +
                                "name,area,numberOfRooms; + \n при этом при перечеслении " +
                                "перечислять через запятую, не использовать пробелы!");
                    }
                } else if (list.get(0).equals("help")) {
                    myCollection.executeCommand(new HelpCommand(), sc, new String[0]);
                } else if (list.get(0).equals("info")) {
                    myCollection.executeCommand(new InfoCommand(), sc, new String[0]);
                } else if (list.get(0).equals("update")) {
                    if (list.size() == 3) {
                        myCollection.executeCommand(new UpdateByIdCommand(), sc, list.toArray(new String[0]));
                    } else {
                        Messages.errorMessageOutput("Что-то пошло не так, какие-то неправильные у тебя аргументы, " +
                                "ты должен подать сначала id, а потом значения полей элемента в таком порядке: " +
                                "name,area,numberOfRooms; + \n при этом при перечеслении " +
                                "перечислять через запятую, не использовать пробелы!");
                    }
                } else if (list.get(0).equals("remove_by_id")) {
                    if (list.size() == 2) {
                        myCollection.executeCommand(new RemoveByIdCommand(), sc, list.toArray(new String[0]));
                    } else {
                        Messages.errorMessageOutput("Что-то не так с аргументом, попробуйте еще раз");
                    }
                } else if (list.get(0).equals("clear")) {
                    myCollection.executeCommand(new ClearCommand(), sc, new String[0]);
                } else if (list.get(0).equals("save")) {
                    myCollection.executeCommand(new SaveCommand(), sc, new String[0]);
                } else if (list.get(0).equals("execute_script")) {
                    if (list.size() == 2) {
                        myCollection.executeCommand(new ExecuteScriptCommand(), sc, list.toArray(new String[0]));
                    } else {
                        Messages.errorMessageOutput("Неправильный ввод аргумента, всего-то ввести filename, верю в Вас");
                    }
                } else if (list.get(0).equals("exit")) {
                    myCollection.executeCommand(new ExitCommand(), sc, new String[0]);
                } else if (list.get(0).equals("remove_first")) {
                    myCollection.executeCommand(new RemoveFirstCommand(), sc, new String[0]);
                } else if (list.get(0).equals("head")) {
                    myCollection.executeCommand(new HeadCommand(), sc, new String[0]);
                } else if (list.get(0).equals("show")) {
                    myCollection.executeCommand(new ShowCommand(), sc, new String[0]);
                } else if (list.get(0).equals("remove_lower")) {
                    if (list.size() == 2) {
                        myCollection.executeCommand(new RemoveLowerCommand(), sc, list.toArray(new String[0]));
                    } else {
                        Messages.errorMessageOutput("Что-то пошло не так, какие-то неправильные у тебя аргументы, " +
                                "ты должен подать значения полей элемента в таком порядке: " +
                                "name,area,numberOfRooms; + \n при этом при перечеслении " +
                                "перечислять через запятую, не использовать пробелы!");
                    }
                } else if (list.get(0).equals("min_by_coordinates")) {
                    myCollection.executeCommand(new MinByCoordinatesCommand(), sc, new String[0]);
                } else if (list.get(0).equals("count_less_than_number_of_rooms")) {
                    if (list.size() == 2) {
                        myCollection.executeCommand(new CountLessCommand(), sc, (list.toArray(new String[0])));
                    } else {
                        Messages.errorMessageOutput("Неправильный ввод аргумента");
                    }
                } else if (list.get(0).equals("print_field_descending_number_of_rooms")) {
                    myCollection.executeCommand(new PrintFieldNumberOfRoomsCommand(), sc, new String[0]);
                } else {
                    Messages.errorMessageOutput("Неправельно введена команда, попробуйте еще раз или напишите help для помощи");
                }

            }
        }
    }

}
