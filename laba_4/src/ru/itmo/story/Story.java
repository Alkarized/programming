package ru.itmo.story;

import ru.itmo.abilities.Leaving;
import ru.itmo.exceptions.CreatedMoreThanOneException;
import ru.itmo.exceptions.NegativeOrZeroNumberException;
import ru.itmo.objects.Box;
import ru.itmo.objects.Newspaper;
import ru.itmo.people.*;

public class Story {

    public static void main(String[] args) throws CreatedMoreThanOneException {
        Kid kid = new Kid();
        Newspaper newspaper = new Newspaper();
        Box box = new Box();
        Julius julius = new Julius();
    }
}
