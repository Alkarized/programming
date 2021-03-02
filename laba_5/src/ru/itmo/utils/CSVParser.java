package ru.itmo.utils;

import ru.itmo.fields.*;

import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;

public class CSVParser {
    public void parse(PriorityQueue<Flat> priorityQueue, InputStreamReader stream) {
        FileReader readerFile = new FileReader();
        LinkedList<String> list = new LinkedList<>();
        while (true) {
            String readLine = readerFile.readLine(stream);
            if (readLine == null) break;
            list.add(readLine);
        }
        for (int i = 0; i < list.size(); i++) {
            String[] params = list.get(i).split(",");
            if (params.length == 13) {
                Flat flat = new Flat();
                boolean canPlace = true;
                params[12] = params[12].substring(0,params[12].length()-1);
                for (int j = 0; j < params.length; j++) {
                    if(!Objects.requireNonNull(params[j]).equals(params[j].trim())){
                        canPlace = false;
                        System.err.println("Ошибка, какие-то лишние пробелы при чтении!");
                    }
                    if (params[j].equals("")) params[j] = null;
                }


                try {
                    if (!flat.setId(Long.valueOf(params[0])) || flat.checkIdUniq(Long.valueOf(params[0]))) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    canPlace = false;
                    System.err.println("Ошибка в представлении занчения id, Id должен быть больше 0, не null или же получили неуникальный id");
                }

                if (!flat.setName(params[1])) {
                    System.err.println("Ошибика при написании поля name - оно не должно быть null или пустым");
                    canPlace = false;
                }

                try {
                    Coordinates coordinates = new Coordinates();
                    if (coordinates.setX(Integer.valueOf(params[2])) && coordinates.setY(Float.valueOf(params[3]))) {
                        flat.setCoordinates(coordinates);
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    canPlace = false;
                    System.err.println("Что-то не так с координатами!");
                }

                try {
                    if (!flat.setCreationDate(new SimpleDateFormat("yyyy-MM-dd;HH:mm:ss.SSS").parse(params[4]))) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    canPlace = false;
                    System.err.println("Неправильный ввод даты");
                }

                try {
                    if (!flat.setArea(Long.valueOf(params[5]))) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    canPlace = false;
                    System.err.println("Ошибка ввода в area");
                }

                try {
                    if (!flat.setNumberOfRooms(Integer.parseInt(params[6]))) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    canPlace = false;
                    System.err.println("Ошибка ввода numberOfRooms");
                }

                try {
                    if (!flat.setFurnish(Furnish.valueOf(params[7]))) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    canPlace = false;
                    System.err.println("Ошибка ввода Furnish");
                }

                try {
                    if (!flat.setView(View.valueOf(params[8]))) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    canPlace = false;
                    System.err.println("Ошибка ввода View");
                }

                try {
                    if (!flat.setTransport(Transport.valueOf(params[9]))) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    canPlace = false;
                    System.err.println("Ошибка ввода Transport");
                }

                try {
                    params[12] = params[12].trim();
                    House house = new House();
                    if (house.setName(params[10]) && house.setYear(Long.valueOf(params[11])) && house.setNumberOfFlatsOnFloor(Long.valueOf(params[12]))) {
                        flat.setHouse(house);
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    canPlace = false;
                    System.err.println("Что-то не так с домиком!");
                }
                if (canPlace) {
                    priorityQueue.add(flat);
                } else {
                    Messages.errorMessageOutput("Ну как понятно из ранних надпесей, простите, Но данная строка - " + (i + 1) + " - не подлижит к добавлению в коллекцию");
                }
            } else {
                Messages.errorMessageOutput("Неправильное кол-во данных в строке - " + (i + 1) + ", данная строка пропущена");
            }
        }
        System.out.println("Ну вот и все, чтение файла закончилось!");
        System.out.println("");
    }
}
