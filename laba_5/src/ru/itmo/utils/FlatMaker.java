package ru.itmo.utils;

import ru.itmo.fields.*;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Класс для создания Нового Flat из командной строки / файла
 */
public class FlatMaker {

    /*public Flat makeFlat(String arg, Scanner scanner) {
        String[] listOfArgs = arg.split(",");
        Flat flat = new Flat();
        try {
            if (checkAmountOfCommasInLine(arg) != 2 || listOfArgs.length != 3 || !flat.setArea(Long.valueOf(listOfArgs[0])) ||
                    !flat.setName(listOfArgs[1]) || !flat.setNumberOfRooms(Integer.valueOf(listOfArgs[2]))) {
                throw new Exception();
            }
        } catch (Exception e) {
            Messages.normalMessageOutput("Неправильный ввод аргументов команды add, попробуйте ввести все еще раз. Порядок: area,name,numberOfRooms");
            return null;
        }

        System.out.println("Введите, пожалуйста, Координаты");
        while (true) {
            try {
                Coordinates coordinates = new Coordinates();
                String line = "";
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                } else {
                    return null;
                }
                String[] strs = line.split(",");
                if (strs.length == 1 && strs[0].trim().equals("end")) {
                    Messages.normalMessageOutput("Ну как скажите, тогда дальше не пойдем.");
                    return null;
                } else if (checkAmountOfCommasInLine(line) == 2 && strs.length == 2 && coordinates.setX(Integer.valueOf(strs[0])) &&
                        coordinates.setY(Float.valueOf(strs[1]))) {
                    flat.setCoordinates(coordinates);
                    break;
                } else {
                    throw new Exception();
                }

            } catch (Exception e) {
                Messages.normalMessageOutput("Что-то не так с координатами! Попробуйте еще раз. Порядок: x,y  \n Вы можете перестать заполнять поля, если напишите end!");
            }

        }

        System.out.println("Введите, пожалуйста, значения полей House");
        while (true) {
            try {
                House house = new House();
                String line = "";
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                } else {
                    return null;
                }
                String[] strs = line.trim().split(",");
                if (strs.length == 1 && strs[0].trim().equals("end")) {
                    Messages.normalMessageOutput("Ну как скажите, тогда дальше не пойдем.");
                    return null;
                } else if (checkAmountOfCommasInLine(line) == 3 && strs.length == 3 && house.setYear(Long.valueOf(strs[0])) &&
                        house.setName(strs[1]) && house.setNumberOfFlatsOnFloor(Long.valueOf(strs[2]))) {
                    flat.setHouse(house);
                    break;
                } else {
                    throw new Exception();
                }

            } catch (Exception e) {
                Messages.normalMessageOutput("Что-то не так с домом! Попробуйте еще раз. Порядок: year,name,numberOfFlatsOnFloor  \n Вы можете перестать заполнять поля, если напишите end!");
            }

        }

        System.out.println("Введите значение для Furnish, есть такие варианты: " + Arrays.toString(Furnish.values()) + "  \n Вы можете перестать заполнять поля, если напишите end!");
        while (true) {
            String line = "";
            if (scanner.hasNextLine()) {
                line = scanner.nextLine();
            } else {
                return null;
            }
            try {
                if (line.trim().equals("end")) {
                    Messages.normalMessageOutput("Ну как скажите, тогда дальше не пойдем.");
                    return null;
                } else if (!flat.setFurnish(Furnish.valueOf(line.trim()))) throw new Exception();
                else break;
            } catch (Exception e) {
                Messages.normalMessageOutput("Что-то не так с furnish! Попробуйте еще раз. Eсть такие варианты: " + Arrays.toString(Furnish.values()) + " \n Вы можете перестать заполнять поля, если напишите end!");
            }
        }

        System.out.println("Введите значение для View, есть такие варианты: " + Arrays.toString(View.values()) + " \n Вы можете перестать заполнять поля, если напишите end!");
        while (true) {
            String line = "";
            if (scanner.hasNextLine()) {
                line = scanner.nextLine();
            } else {
                return null;
            }
            try {
                if (line.trim().equals("end")) {
                    Messages.normalMessageOutput("Ну как скажите, тогда дальше не пойдем.");
                    return null;
                } else if (!flat.setView(View.valueOf(line.trim()))) throw new Exception();
                else break;
            } catch (Exception e) {
                Messages.normalMessageOutput("Что-то не так с видом! Попробуйте еще раз. Eсть такие варианты: " + Arrays.toString(View.values()) + " \n Вы можете перестать заполнять поля, если напишите end!");
            }
        }

        System.out.println("Введите значение для Transport, есть такие варианты: " + Arrays.toString(Transport.values()) + " \n Вы можете перестать заполнять поля, если напишите end!");
        while (true) {
            String line = "";
            if (scanner.hasNextLine()) {
                line = scanner.nextLine();
            } else {
                return null;
            }
            try {
                if (line.trim().equals("end")) {
                    Messages.normalMessageOutput("Ну как скажите, тогда дальше не пойдем.");
                    return null;
                } else if (!flat.setTransport(Transport.valueOf(line.trim()))) throw new Exception();
                else break;
            } catch (Exception e) {
                Messages.normalMessageOutput("Что-то не так с транспортом! Попробуйте еще раз. Eсть такие варианты: " + Arrays.toString(Transport.values()) + " \n Вы можете перестать заполнять поля, если напишите end!");
            }
        }

        return flat;
    }*/

    /**
     * Создание нового Flat
     *
     * @param scanner указывает откуда считывать
     * @return возвращает новый созданный Flat
     */
    public Flat makeFlat(Scanner scanner) {
        Flat flat = new Flat();
        String line;
        while (true) {
            System.out.print("Введите значение для поля area: ");
            try {
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine().trim();
                } else {
                    return null;
                }
                System.out.println();
                if (line.equals("end")) {
                    System.out.println("Ну как скажите, тогда дальше не пойдем.");
                    return null;
                }
                if (flat.setArea(Long.valueOf(line))) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода поля area, попробуйте еще раз или напишите end");
            }
        }

        while (true) {
            System.out.print("Введите значение для поля name: ");
            try {
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine().trim();
                } else {
                    return null;
                }
                System.out.println();
                if (line.equals("end")) {
                    System.out.println("Ну как скажите, тогда дальше не пойдем.");
                    return null;
                }
                if (flat.setName(line)) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода поля name, попробуйте еще раз или напишите end");
            }
        }

        while (true) {
            System.out.print("Введите значение для поля numberOfRooms: ");
            try {
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine().trim();
                } else {
                    return null;
                }
                System.out.println();
                if (line.equals("end")) {
                    System.out.println("Ну как скажите, тогда дальше не пойдем.");
                    return null;
                }
                if (flat.setNumberOfRooms(Integer.valueOf(line))) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода поля numberOfRooms, попробуйте еще раз или напишите end");
            }
        }

        House house = new House();
        System.out.println("Теперь необходимо создать объект дома, для этого:");
        while (true) {
            System.out.print("Введите значение для поля name: ");
            try {
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine().trim();
                } else {
                    return null;
                }
                System.out.println();
                if (line.equals("end")) {
                    System.out.println("Ну как скажите, тогда дальше не пойдем.");
                    return null;
                }
                if (house.setName(line)) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода поля name, попробуйте еще раз или напишите end");
            }
        }

        while (true) {
            System.out.print("Введите значение для поля year: ");
            try {
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine().trim();
                } else {
                    return null;
                }
                System.out.println();
                if (line.equals("end")) {
                    System.out.println("Ну как скажите, тогда дальше не пойдем.");
                    return null;
                }
                if (house.setYear(Long.valueOf(line))) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода поля year, попробуйте еще раз или напишите end");
            }
        }

        while (true) {
            System.out.print("Введите значение для поля numberOfFlatsOnFloor: ");
            try {
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine().trim();
                } else {
                    return null;
                }
                System.out.println();
                if (line.equals("end")) {
                    System.out.println("Ну как скажите, тогда дальше не пойдем.");
                    return null;
                }
                if (house.setNumberOfFlatsOnFloor(Long.valueOf(line))) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода поля numberOfFlatsOnFloor, попробуйте еще раз или напишите end");
            }
        }

        flat.setHouse(house);

        Coordinates coordinates = new Coordinates();
        System.out.println("Теперь необходимо создать Координаты, для этого:");
        while (true) {
            System.out.print("Введите значение для поля x: ");
            try {
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine().trim();
                } else {
                    return null;
                }
                System.out.println();
                if (line.equals("end")) {
                    System.out.println("Ну как скажите, тогда дальше не пойдем.");
                    return null;
                }
                if (coordinates.setX(Integer.valueOf(line))) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода поля x, попробуйте еще раз или напишите end");
            }
        }

        while (true) {
            System.out.print("Введите значение для поля y: ");
            try {
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine().trim();
                } else {
                    return null;
                }
                System.out.println();
                if (line.equals("end")) {
                    System.out.println("Ну как скажите, тогда дальше не пойдем.");
                    return null;
                }
                if (coordinates.setY(Float.valueOf(line))) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода поля y, попробуйте еще раз или напишите end");
            }
        }

        flat.setCoordinates(coordinates);

        while (true) {
            System.out.print("Введите значение для поля transport, есть такие значения + " + Arrays.toString(Transport.values()) + " : ");
            try {
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine().trim();
                } else {
                    return null;
                }
                System.out.println();
                if (line.equals("end")) {
                    System.out.println("Ну как скажите, тогда дальше не пойдем.");
                    return null;
                }
                if (flat.setTransport(Transport.valueOf(line))) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода поля transport, попробуйте еще раз или напишите end");
            }
        }

        while (true) {
            System.out.print("Введите значение для поля view, есть такие значения + " + Arrays.toString(View.values()) + " : ");
            try {
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine().trim();
                } else {
                    return null;
                }
                System.out.println();
                if (line.equals("end")) {
                    System.out.println("Ну как скажите, тогда дальше не пойдем.");
                    return null;
                }
                if (flat.setView(View.valueOf(line))) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода поля view, попробуйте еще раз или напишите end");
            }
        }

        while (true) {
            System.out.print("Введите значение для поля furnish, есть такие значения + " + Arrays.toString(Furnish.values()) + " : ");
            try {
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine().trim();
                } else {
                    return null;
                }
                System.out.println();
                if (line.equals("end")) {
                    System.out.println("Ну как скажите, тогда дальше не пойдем.");
                    return null;
                }
                if (flat.setFurnish(Furnish.valueOf(line))) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода поля furnish, попробуйте еще раз или напишите end");
            }
        }

        return flat;
    }

    /**
     * Узнать, сколько запятых используется в строке
     *
     * @param line сама строка
     * @return количество запятых
     */
    private int checkAmountOfCommasInLine(String line) {
        int amount = 0;
        for (char x : line.toCharArray()) {
            if (x == ',') amount++;
        }
        return amount;
    }
}
