package itmo.ru.people;

import itmo.ru.abilities.*;
import itmo.ru.enumobjs.Gender;
import itmo.ru.enumobjs.Instructions;
import itmo.ru.others.Phone;

public class FrekenBock extends AHuman implements IInstruct, ISpeak, IWalkTo, IHelp {
    @Override
    public void instructJulius(Instructions instruction, Julius who) {
        if(instruction!=null){
            String instr = "";
            switch (instruction){
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
    }

    @Override
    public void speakByPhone(boolean isLoud, Phone phone) {
        String loud = isLoud ? " громко" : "";
        System.out.println(getName() + " говорила" + loud + " по " + phone.getType() + "у");
    }

    @Override
    public void walkTo(Object to) {
        System.out.println(getName() + " подошла к " + ((Phone)to).getType());
    }

    @Override
    public void helpTo(AHuman human, String whichHelp) {
        System.out.println(getName() + " помогала " + human.getName() + "у " + whichHelp);
    }

    public FrekenBock(){
        setGender(Gender.FEMALE);
        setName("Фрекен Бок");
    }

}
