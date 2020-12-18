package ru.itmo.objects;

import java.util.ArrayList;

public class Box {
    ArrayList<Things> items = new ArrayList<>();

    public void getListOfItemsInBox() {
        StringBuilder list = new StringBuilder("В ящике лежат такие вещи: \n");
        for (int i = 0; i < items.size(); i++) {
            list.append(i).append(". ").append(items.get(i).getName());
        }
        if(items.size() == 0){
            System.out.println("В ящике нет вещей");
        } else{
            System.out.println(list.toString());
        }
    }

    public ArrayList<Things> getItemsInBox() {
        return items;
    }

    public void removeItemsInBox(int index) {
        items.remove(index);
    }

    public void isItemInsideBox(Things things){
        for (Things thing: items) {
            if(thing.getClass().equals(things.getClass())){
                System.out.println(things.getName() + " лежит в ящике стола");
            }
        }
    }

    public void addItemsInBox(Things... things){
        for (Things thing: things) {
            items.add(thing);
            if(thing.getClass().equals(Newspaper.class)){
                ((Newspaper) thing).setBox(this);
            }
        }
    }
}

