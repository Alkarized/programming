/*
Фрекен Бок помогала ему укладывать вещи, и Малыш и Карлсон слышали,
как она его попутно наставляла: чтобы он не забыл застегнуть верхнюю пуговицу на пальто,
а то еще продует, и чтобы он осторожно переходил улицу, и чтобы не курил натощак!
Но этот день странным образом оказался полон сюрпризов.
Не успел дядя Юлиус уйти, как фрекен Бок кинулась к телефону.
И она говорила так громко, что Малыш и Карлсон невольно услышали весь ей разговор.
*/
package itmo.ru.main;

import itmo.ru.enumobjs.Gender;
import itmo.ru.enumobjs.HearType;
import itmo.ru.enumobjs.Instructions;
import itmo.ru.others.Day;
import itmo.ru.others.Phone;
import itmo.ru.people.FrekenBock;
import itmo.ru.people.Heroes;
import itmo.ru.people.Julius;

public class MyTale {

    public static void main(String[] args) {
        FrekenBock frekenBock = new FrekenBock();
        Heroes kid = new Heroes("Малыш", Gender.MALE);
        Heroes carlson = new Heroes("Карлосон");
        Julius julius = new Julius();
        frekenBock.helpTo(julius, "укладывать вещи");
        kid.hear(frekenBock, HearType.INSTRUCTIONS, true);
        carlson.hear(frekenBock, HearType.INSTRUCTIONS, true);
        frekenBock.instructJulius(Instructions.FASTEN_THE_TOP_BUTTON, julius);
        frekenBock.instructJulius(Instructions.CAREFULLY_CROSS_THE_STREET, julius);
        frekenBock.instructJulius(Instructions.DO_NOT_SMOKE_ON_AN_EMPTY_STOMACH, julius);
        Day day = new Day();
        day.setDayFullOfSurprises();
        julius.walkAway(false);
        Phone phone = new Phone("Телефон", "old-2");
        frekenBock.walkTo(phone);
        frekenBock.speakByPhone(true, phone);
        kid.hear(frekenBock, HearType.SPEECH, false);
        carlson.hear(frekenBock, HearType.SPEECH, false);
    }
}
