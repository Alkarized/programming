package ru.itmo.objects;

public class Table {
    //I can make box Inner class
    private final Box box;

    public Table(Box box) {
        this.box = box;
    }

    public Box getBox() {
        return box;
    }
}
