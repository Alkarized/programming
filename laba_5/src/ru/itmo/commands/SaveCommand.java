package ru.itmo.commands;

import ru.itmo.collection.MyCollection;
import ru.itmo.fields.Flat;
import ru.itmo.utils.Messages;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SaveCommand extends Command {

    @Override
    public boolean execute(MyCollection myCollect, Scanner scanner, String[] args) {
        this.myCollection = myCollect;

        try {
            PrintWriter pw = new PrintWriter(myCollection.getFile());
            if (myCollection.getCollection().size() > 0) {
                for (Flat flat : myCollection.getCollection()) {
                    pw.println(flat.getId() + "," +
                            flat.getName() + "," +
                            flat.getCoordinates().getX() + "," +
                            flat.getCoordinates().getY() + "," +
                            flat.getCreationDate() + "," +
                            flat.getArea() + "," +
                            flat.getNumberOfRooms() + "," +
                            flat.getFurnish() + "," +
                            flat.getView() + "," +
                            flat.getTransport() + "," +
                            flat.getHouse().getName() + "," +
                            flat.getHouse().getYear() + "," +
                            flat.getHouse().getNumberOfFlatsOnFloor());
                    pw.flush();
                }
                Messages.normalMessageOutput("Произошло сохранение");
            } else {
                Messages.normalMessageOutput("Ты шизиод? тут нечего сохранять!!Но я все равно сохраню пустой файлик");
                pw.write("");
                pw.flush();
            }
            return true;
        } catch (FileNotFoundException e) {
            Messages.errorMessageOutput("Ну какие-то проблемки с выводом в файл");
            return false;
        }

    }
}
