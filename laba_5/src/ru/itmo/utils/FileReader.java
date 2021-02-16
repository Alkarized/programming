package ru.itmo.utils;

import ru.itmo.utils.Messages;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader {

    public String getFileNameFromArgs(String[] args) {
        String fileName = null;
        if (args.length == 1) {
            fileName = args[0] + setFormat(checkFormat(args[0]));
            checkAllPermissions(new File(fileName));
            Messages.normalMessageOutput("Полученный файл - " + fileName);

        } else {
            Messages.errorMessageOutput("Неправильный ввод названия файла! Попробуйте еще раз!");
            System.exit(1);
        }
        return fileName;
    }

    private boolean checkFormat(String args) {
        StringBuilder lastFourWords = new StringBuilder();
        if (args.length() >= 4) {
            for (int i = 4; i > 0; i--) {
                lastFourWords.append(args.charAt(args.length() - i));
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

    public String readLine(InputStreamReader stream){
        String line = "";
        while (true){
            try {
                int x = stream.read();
                //System.out.print(x + " ");
                if(x == 10)
                    return line;
                else if(x == -1)
                    return null;
                else
                    line += (char)x + "";
            } catch (IOException ignored) {

            }
        }
    }
}
