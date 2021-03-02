package ru.itmo.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;

public class CSVFileReader {

    public String getFileNameFromArgs(String[] args) {
        String fileName = null;
        if (args.length == 1) {
            fileName = args[0] + setFormat(checkFormat(args[0]));
            checkAllPermissions(new File(fileName));
            Messages.normalMessageOutput("Полученный файл - " + fileName);
        } else {
            Messages.errorMessageOutput("Неправильный ввод, что-то не так с аргументами при запуске программы, попробуйте еще раз");
            System.exit(1);
        }
        return fileName;
    }

    private boolean checkFormat(String arg) {
        StringBuilder lastFourWords = new StringBuilder();
        if (arg.length() >= 4) {
            for (int i = 4; i > 0; i--) {
                lastFourWords.append(arg.charAt(arg.length() - i));
            }
        }

        return lastFourWords.toString().toLowerCase().equals(".csv");
    }

    private String setFormat(boolean isNotNeedToSet) {
        if (isNotNeedToSet) {
            return "";
        } else {
            return ".csv";
        }
    }

    private void checkAllPermissions(File file) {
        if (file.exists()) {
            if ((!file.canWrite()) && (!file.canRead())) {
                Messages.errorMessageOutput("Файл нельзя считать и что-то в него записать, давай исправляй, сударь!");
                System.exit(1);
            } else if ((!file.canWrite()) && file.canRead()) {
                Messages.errorMessageOutput("Уууупс, а в файлик-то ничего записать нельзя, а смысл в чем? Зайкрой и открой нормально");
                System.exit(1);
            } else if (file.canWrite() && (!file.canRead())) {
                Messages.errorMessageOutput("Ну что-то явно пошло не так, дай права на чтение пощупать.");
                System.exit(1);
            }
        }
    }

    public ArrayList<String> readAllLines(File file) {
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            StringBuilder line = new StringBuilder("");
            while (true) {
                int data = reader.read();
                if (data == -1) {
                    break;
                } else {
                    line.append((char) data);
                }
            }
            String[] lines = String.valueOf(line).split(System.getProperty("line.separator"));
            return new ArrayList<>(Arrays.asList(lines));
        } catch (FileNotFoundException e) {
            Messages.normalMessageOutput("Файл не был найден, возможно он еще не существует, не беда");
            return null;
        } catch (IOException e) {
            Messages.errorMessageOutput("Какая-то ошибка с IO, выключаемся");
            System.exit(1);
            return null;
        }
    }
}
