package ru.itmo.people;

import ru.itmo.abilities.WalkableToRooms;
import ru.itmo.enums.Gender;
import ru.itmo.enums.HouseRooms;
import ru.itmo.exceptions.DelPerformedActionsException;

import java.util.ArrayList;

public abstract class Human implements WalkableToRooms {
    private String name;
    private int age;
    private Gender gender;
    private HouseRooms houseRoom;
    private final ArrayList<String> performedActions = new ArrayList<>();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public HouseRooms getHouseRoom() {
        return houseRoom;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    protected void setGender(Gender gender) {
        this.gender = gender;
    }

    protected void setHouseRoom(HouseRooms houseRoom) {
        this.houseRoom = houseRoom;
    }

    //Add check if size == 0 and throw an Exception.
    public void getListOfPerformedActions() {
        String gender = getGender()==Gender.MALE? " совершил" : " совершила";
        StringBuilder actions = new StringBuilder(getName() + gender + " такие действия: \n");
        for (int i = 0; i < performedActions.size(); i++) {
            actions.append(i + 1).append(". ").append(performedActions.get(i)).append("\n");
        }
        if (performedActions.size() == 0){
            System.out.println(getName() + ": " + "персонаж не совершал никаких действий");
        } else {
            System.out.println(actions.toString());
        }
    }

    public void getLastPerformedAction(){
        System.out.println(getName() + " " + performedActions.get(performedActions.size()-1));
    }

    public void addPerformedActions(String action) {
        performedActions.add(action);
    }

    //Always throw exception.
    public void delPerformedActionsByIndex(int index) {
        if(index < 0 || index > performedActions.size()){
            throw new IndexOutOfBoundsException("Ты вышел за границы дозволенного");
        } else {
            throw new DelPerformedActionsException();
        }
    }

    public boolean equals(Object o) {
        return ((Human) o).getGender().equals(getGender()) &&
                ((Human) o).getName().equals(getName()) &&
                ((Human) o).getAge() == getAge() &&
                ((Human) o).getHouseRoom() == getHouseRoom() &&
                getClass().equals(o.getClass());
    }

    public int hashCode() {
        int hash = 0;
        int houseRoomCoords = getHouseRoom().getX() + getHouseRoom().getY() + getHouseRoom().getZ();
        int gen = getGender().equals(Gender.MALE) ? 1 : 0;
        for (char x : getName().toCharArray()) {
            if (Integer.MAX_VALUE - hash < Character.MAX_VALUE * 75 + 12 + getAge() + gen + houseRoomCoords)
                hash += x * 12 + 12 + getAge() + gen + houseRoomCoords;
            else {
                hash -= x * 7 + 43 + getAge() + gen + houseRoomCoords;
            }
        }
        return Math.abs(hash);
    }

    @Override
    public String toString() {
        return "Это человек по имени: " + getName() + ", пола: " + getGender() + ", возраста: " + getAge() +
                ", ушедший когда-то " + getHouseRoom().getRoomName() + " и не вернувшийся оттуда";
    }

    @Override
    public void walkToRoom(HouseRooms houseRoom) {
        setHouseRoom(houseRoom);
        String gender = getGender().equals(Gender.MALE) ? "ушел" : "ушла";
        String output = gender + " " + houseRoom.getRoomName();
        System.out.println(getName() + " " + output);
        addPerformedActions(output);
    }

}
