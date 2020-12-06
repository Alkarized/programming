package itmo.ru.people;

import itmo.ru.abilities.IHelp;
import itmo.ru.abilities.IInstruct;
import itmo.ru.abilities.IPhoneActions;
import itmo.ru.abilities.IWalkToRoom;
import itmo.ru.enums.*;
import itmo.ru.other.Phone;

public class FrekenBock extends AHuman implements IHelp, IPhoneActions, IInstruct {

    public FrekenBock() {
        setName("Фрекен Бок");
        setAge(42);
        setGender(Gender.FEMALE);
        setHouseRoom(HouseRooms.FIRST_ROOM);
    }


    @Override
    public void helpToWith(AHuman toHuman, HelpType helpType) {
        System.out.println(getName() + " помогала " + toHuman.getName() + "у " + helpType.getWhatHelp());
    }

    //Add exception if FrekenBock started speakByPhone,
    //but first of all she didnt walk to phone.
    @Override
    public void walkToPhone(Phone toPhone, boolean isFast) {
        String went = isFast ? " кинулась " : " подошла ";
        System.out.println(getName() + went + "к " + toPhone.getPhoneType().getWhatPhone());
    }

    //Add exception if Julius and FrekenBok are not in the same room.
    @Override
    public void instructJulius(Instructions instruction, Julius who, Observers observers) {
        if(getHouseRoom().equals(who.getHouseRoom())) {
            System.out.println(getName() + " наставляла " + who.getName() + "а, чтобы он " + instruction.getWhichInstruction());
            observers.notifyObservers(this,
                    HearType.INSTRUCTIONS.getWhatType() + " " + getName()
                            + " " + who.getName() + "у, чтобы тот",
                    instruction.getWhichInstruction());
        }
    }

    @Override
    public void speakByPhone(boolean isLoud, Phone phone, String text, Observers observers) {
        String loud = isLoud ? "громкий " : "";
        System.out.println(getName() + " начала " + loud + HearType.SPEECH.getWhatType()
                + " по " + phone.getPhoneType().getWhatPhone() + ": " + text);
        observers.notifyObservers(this,
                loud + HearType.SPEECH.getWhatType() + " " + getName()
                        + " по " + phone.getPhoneType().getWhatPhone() + ":",
                text);
    }
}

