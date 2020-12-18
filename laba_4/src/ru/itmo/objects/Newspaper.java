package ru.itmo.objects;

import ru.itmo.exceptions.CreatedMoreThanOneException;

import java.util.ArrayList;

public class Newspaper extends Things{
    private Box box;
    private static boolean isOneCreated = false;

    //Exception here! if is created, cant create more than one!
    public Newspaper() throws CreatedMoreThanOneException {
        super("газета");
        if(isOneCreated){
            throw new CreatedMoreThanOneException(getClass());
        } else {
            isOneCreated = true;
        }
    }

    public void setBox(Box box) {
        this.box = box;
    }

    //is null?
    public void isInBox(){
        boolean isInside = false;
        if(box != null){
            ArrayList<Things> items = box.getItemsInBox();
            for (Things item : items) {
                if (item.getClass().equals(Newspaper.class)) {
                    isInside = true;
                    break;
                }
            }
        }
        if(!isInside){
            System.out.println(getName() + " не лежит в ящике стола");
        } else {
            System.out.println(getName() + " лежит в ящике стола");
        }
    }
}
