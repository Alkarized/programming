package ru.itmo.utils;

import ru.itmo.fields.*;

import java.util.Arrays;
import java.util.Scanner;

public class FlatMaker {
    public boolean makeNewFlat(Flat flat, String firstArg, Scanner scanner){
        String[] strList = firstArg.split(",");
        System.out.println(firstArg);
        try {
            if (strList.length != 3) throw new Exception();
            if (!flat.setName(strList[0].trim())) throw new Exception();
            if (!flat.setArea(Long.valueOf(strList[1].trim())) || !flat.setNumberOfRooms(Integer.parseInt(strList[2].trim())))
                throw new Exception();
        } catch (Exception e) {
            Messages.errorMessageOutput("Неправильный ввод аргументов команды add, попробуйте ввести все еще раз. Порядок: name,area,numberOfRooms");
            return false;
        }
        System.out.println("Введите, пожалуйста, Координаты");
        while (true) {
            try {
                String line = "";
                if(scanner.hasNextLine()) {
                    line = scanner.nextLine();
                } else {
                    return false;
                }
                System.out.println(line);
                String[] strs = line.split(",");
                if (strs.length != 2) {throw new Exception();}
                Coordinates coordinates = new Coordinates();
                if (!coordinates.setX(Integer.valueOf(strs[0].trim())) || !coordinates.setY(Float.valueOf(strs[1].trim()))) throw new Exception();
                else {
                    flat.setCoordinates(coordinates);
                    break;
                }
            } catch (Exception e) {
                Messages.errorMessageOutput("Что-то не так с координатами! Попробуйте еще раз. Порядок: x,y");
            }
        }

        System.out.println("Введите значения полей House");
        while (true){
            String line = "";
            if(scanner.hasNextLine()) {
                line = scanner.nextLine();
            } else {
                return false;
            }
            System.out.println(line);
            String[] strs = line.split(",");
            try {
                if (strs.length != 3) throw new Exception();
                House house = new House();
                if (!house.setName(strs[0].trim()) || !house.setYear(Long.valueOf(strs[1].trim())) || !house.setNumberOfFlatsOnFloor(Long.valueOf(strs[2].trim()))) throw new Exception();
                else {
                    flat.setHouse(house);
                    break;
                }
            } catch (Exception ignored) {
                Messages.errorMessageOutput("Что-то не так с домишкой! Попробуйте еще раз. Порядок: name,year,numberOfFlatsOnFloor");
            }
        }

        System.out.println("Введите значение для Furnish, есть такие варианты: " + Arrays.toString(Furnish.values()));
        while (true){
            String line = "";
            if(scanner.hasNextLine()) {
                line = scanner.nextLine();
            } else {
                return false;
            }
            System.out.println(line);
            try {
                if(!flat.setFurnish(Furnish.valueOf(line))) throw new Exception();
                else break;
            } catch (Exception e) {
                Messages.errorMessageOutput("Что-то не так с furnish! Попробуйте еще раз. Eсть такие варианты: " + Arrays.toString(Furnish.values()));
            }
        }

        System.out.println("Введите значение для View, есть такие варианты: " + Arrays.toString(View.values()));
        while (true){
            String line = "";
            if(scanner.hasNextLine()) {
                line = scanner.nextLine();
            } else {
                return false;
            }
            System.out.println(line);
            try {
                if(!flat.setView(View.valueOf(line))) throw new Exception();
                else break;
            } catch (Exception e) {
                Messages.errorMessageOutput("Что-то не так с видом! Попробуйте еще раз. Eсть такие варианты: " + Arrays.toString(View.values()));
            }
        }

        System.out.println("Введите значение для Transport, есть такие варианты: " + Arrays.toString(Transport.values()));
        while (true){
            String line = "";
            if(scanner.hasNextLine()) {
                line = scanner.nextLine();
            } else {
                return false;
            }
            System.out.println(line);
            try {
                if(!flat.setTransport(Transport.valueOf(line))) throw new Exception();
                else break;
            } catch (Exception e) {
                Messages.errorMessageOutput("Что-то не так с транспортом! Попробуйте еще раз. Eсть такие варианты: " + Arrays.toString(Transport.values()));
            }
        }
        return true;
    }
}
