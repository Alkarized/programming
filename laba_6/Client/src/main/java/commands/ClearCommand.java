package commands;


import client.Receiver;
import message.MessageColor;
import message.Messages;

import java.io.Serializable;
import java.util.Scanner;


public class ClearCommand extends Command implements Serializable {
    private static final long serialVersionUID = 51;


    public ClearCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 1)
            receiver.clear();
        else
            Messages.normalMessageOutput("Неправильно введены аргументы", MessageColor.ANSI_RED);
    }

    @Override
    public void execute(String[] args, Scanner scanner) {
        execute(args);
    }

}