package itmo.ru.people;

import itmo.ru.abilities.*;
import itmo.ru.enums.Gender;
import itmo.ru.enums.HelpType;
import itmo.ru.enums.Instructions;
import itmo.ru.enums.PhoneTypes;
import itmo.ru.other.Phone;

import java.sql.SQLOutput;

public class FrekenBock extends AHuman implements IActions {

    public FrekenBock() {
        setName("Фрекен Бок");
        setAge(42);
        setGender(Gender.FEMALE);
    }


    @Override
    public void helpToWith(AHuman toHuman, HelpType helpType) {
        System.out.println(getName() + " помогала " + toHuman.getName() + "у " + helpType.getHelp());
    }

    @Override
    public void instructJulius(Instructions instruction, Julius who) {
        System.out.println(getName() + " наставляла " + who.getName() + "а" + instruction.getInst());

    }

    @Override
    public void speakByPhone(boolean isLoud, Phone phone) {
        String loud = isLoud ? " громко " : " ";
        System.out.println(getName() + loud + "разговаривала по " + phone.getPhoneType().getWhatPhone());
    }

    @Override
    public void walkToPhone(Phone toPhone, boolean isFast) {
        String went = isFast ? " кинулась " : " подошла ";
        System.out.println(getName() + went + "к " + toPhone.getPhoneType().getWhatPhone());

    }
}

