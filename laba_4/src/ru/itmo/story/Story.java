package ru.itmo.story;

import ru.itmo.exceptions.CreatedMoreThanOneException;
import ru.itmo.objects.Box;
import ru.itmo.objects.Newspaper;
import ru.itmo.objects.Table;
import ru.itmo.people.FrekenBock;
import ru.itmo.people.Kid;
import ru.itmo.people.Listeners;

public class Story {

    public static void main(String[] args) throws CreatedMoreThanOneException {
        Kid kid = new Kid();
        Newspaper newspaper = new Newspaper();
        Box box = new Box();
    }
}
