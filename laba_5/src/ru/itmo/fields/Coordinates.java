package ru.itmo.fields;

public class Coordinates {
    private Integer x; //Поле не может быть null
    private Float y; //Максимальное значение поля: 687, Поле не может быть null

    public Integer getX() {
        return x;
    }

    public boolean setX(Integer x) {
        if(x==null){
            return false;
        } else {
            this.x = x;
            return true;
        }
    }

    public Float getY() {
        return y;
    }

    public boolean setY(Float y) {
        if(y==null||y>687){
            return false;
        } else {
            this.y = y;
            return true;
        }
    }

    /*public Coordinates(Integer x, Float y) {
        this.x = x;
        this.y = y;
    }*/
}
