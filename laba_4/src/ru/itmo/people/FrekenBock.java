package ru.itmo.people;

import ru.itmo.enums.Gender;
import ru.itmo.enums.HouseRooms;

public class FrekenBock extends Human{
    public FrekenBock() {
        setName("Фрекен Бок");
        setAge(42);
        setGender(Gender.FEMALE);
        setHouseRoom(HouseRooms.FIRST_ROOM);
    }

}
