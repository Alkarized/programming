package ru.itmo.objects;

public abstract class Things {
    private final String name;

    //Add exception if null!
    public Things(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
