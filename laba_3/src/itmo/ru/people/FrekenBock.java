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
        String help = helpType.equals(HelpType.PACK_THINGS) ? " укладывать вещи " : " одеваться ";
        System.out.println(getName() + " помогала " + toHuman.getName() + "у" + help);
    }

    @Override
    public void instructJulius(Instructions instruction, Julius who) {
        String instr = "";
        switch (instruction) {
            case FASTEN_THE_TOP_BUTTON:
                instr = ", чтобы он не забыл застегнуть верхнюю пуговицу на пальто, а то продует!";
                break;
            case CAREFULLY_CROSS_THE_STREET:
                instr = ", чтобы он осторожно переходил улицу!";
                break;
            case DO_NOT_SMOKE_ON_AN_EMPTY_STOMACH:
                instr = ", чтобы он не курил натощак!";
                break;
        }

        System.out.println(getName() + " наставляла " + who.getName() + "а" + instr);

    }

    @Override
    public void speakByPhone(boolean isLoud, Phone phone) {
        String phoneT = phone.getPhoneType().equals(PhoneTypes.PHONE) ? " телефону" : " смартфону";
        String loud = isLoud ? " громко " : " ";
        System.out.println(getName() + loud + "разговаривала по" + phoneT);
    }

    @Override
    public void walkToPhone(Phone toPhone, boolean isFast) {
        String went = isFast ? " кинулась " : " подошла ";
        if (toPhone.getPhoneType().equals(PhoneTypes.PHONE))
            System.out.println(getName() + went + "к телефону");
        else if (toPhone.getPhoneType().equals(PhoneTypes.SMARTPHONE))
            System.out.println(getName() + went + "к смартфону");
    }
}

