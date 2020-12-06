package itmo.ru.people;

import itmo.ru.abilities.IWalkAway;
import itmo.ru.abilities.IWalkToRoom;
import itmo.ru.enums.Gender;
import itmo.ru.enums.HouseRooms;

public class Julius extends AHuman implements IWalkAway {
    public Julius() {
        setName("Юлиус");
        setAge(45);
        setGender(Gender.MALE);
        setHouseRoom(HouseRooms.FIRST_ROOM);
    }


    @Override
    public void walkAway(boolean isManagedWalkAway) {
        if (isManagedWalkAway)
            System.out.println(getName() + " ушёл из дома");
        else
            System.out.println(getName() + " не успел уйти из дома, как");
    }
}
