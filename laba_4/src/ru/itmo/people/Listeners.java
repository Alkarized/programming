package ru.itmo.people;

import ru.itmo.enums.Gender;
import ru.itmo.enums.HouseRooms;

public class Listeners extends Human {
    protected Listeners(String name, int age, Gender gender, HouseRooms houseRoom) {
        setName(name);
        setAge(age);
        setGender(gender);
        setHouseRoom(houseRoom);
    }

    public void notifyListener(Human human, String notMixingText, String mixingText) {
        int difX = Math.abs(human.getHouseRoom().getX() - getHouseRoom().getX());
        int difY = Math.abs(human.getHouseRoom().getY() - getHouseRoom().getY());
        int difZ = Math.abs(human.getHouseRoom().getZ() - getHouseRoom().getZ());
        int dif = difX + difY + difZ;
        if (dif <= 1) {
            String gender = Gender.MALE.equals(getGender()) ? "услышал" : "услышала";
            String mixed = getHearText(mixingText, difX, difY, dif);
            System.out.println(getName() + " " + gender + " " + notMixingText + " " + mixed);
        }
    }

    public String getHearText(String hearText, int difX, int difY, int dif) {
        String text = " ";
        return text;

    }
}
