package ru.itmo.people;

import ru.itmo.enums.Gender;
import ru.itmo.enums.HouseRooms;

public class Julius extends Human{
    public Julius() {
        setName("Юлиус");
        setAge(45);
        setGender(Gender.MALE);
        setHouseRoom(HouseRooms.FIRST_ROOM);
    }
}
