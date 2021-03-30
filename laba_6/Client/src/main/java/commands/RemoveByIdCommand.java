package commands;


import client.Receiver;
import message.MessageColor;
import message.Messages;

import java.io.Serializable;
import java.util.Scanner;

public class RemoveByIdCommand extends Command implements Serializable {
    private static final long serialVersionUID = 59;


    public RemoveByIdCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute(String[] args) {

        try {
            if (args.length == 2)
                receiver.removeById(Long.valueOf(args[1]));
            else
                throw new Exception();
        } catch (Exception e) {
            Messages.normalMessageOutput("Неправильно введены аргументы", MessageColor.ANSI_RED);        }

    }

    @Override
    public void execute(String[] args, Scanner scanner) {

    }

}
