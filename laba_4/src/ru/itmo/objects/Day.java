package ru.itmo.objects;

public class Day {
    private boolean isDayFullOfSurprises;

    public boolean isDayFullOfSurprises(){
        return isDayFullOfSurprises;
    }

    //Add checked Exception!
    public void setDayFullOfSurprises(){
        if(!isDayFullOfSurprises()) {
            isDayFullOfSurprises = true;
            System.out.println("День странным образом оказался полон сюрпризов!");
        } else {
            System.out.println("День уже давно полон сюрпризов, куда еще.");
        }
    }
}
