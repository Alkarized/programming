package ru.itmo.fields;

public class House {
    private String name; //Поле может быть null
    private Long year; //Значение поля должно быть больше 0
    private Long numberOfFlatsOnFloor; //Значение поля должно быть больше 0

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if(name.equals("")) this.name = null;
        else this.name = name;
        return true;
    }

    public Long getYear() {
        return year;
    }

    public boolean setYear(Long year) {
        if(year > 0) {
            this.year = year;
            return true;
        } else {
            return false;
        }
    }

    public Long getNumberOfFlatsOnFloor() {
        return numberOfFlatsOnFloor;
    }

    public boolean setNumberOfFlatsOnFloor(Long numberOfFlatsOnFloor) {
        if(numberOfFlatsOnFloor > 0) {
            this.numberOfFlatsOnFloor = numberOfFlatsOnFloor;
            return true;
        } else {
            return false;
        }
    }

    /*public House(String name, Long year, Long numberOfFlatsOnFloor) {
        this.name = name;
        this.year = year;
        this.numberOfFlatsOnFloor = numberOfFlatsOnFloor;
    }*/
}
