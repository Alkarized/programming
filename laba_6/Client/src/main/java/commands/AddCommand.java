package commands;

import client.Receiver;
import fields.Flat;
import message.MessageColor;
import message.Messages;
import utils.FlatMaker;

import java.io.Serializable;
import java.util.Scanner;

public class AddCommand extends Command implements Serializable {
    private static final long serialVersionUID = 50;


    public AddCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute(String[] args) {
        execute(args, new Scanner(System.in));
    }

    @Override
    public void execute(String[] args, Scanner scanner) {
        Flat flat = new FlatMaker().makeFlat(scanner);
        if (flat != null && args.length == 1)
            receiver.addElement(scanner, flat);
        else
            Messages.normalMessageOutput("Неправильно введены аргументы", MessageColor.ANSI_RED);
    }
}
