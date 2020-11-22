/*
Фрекен Бок помогала ему укладывать вещи, и Малыш и Карлсон слышали,
как она его попутно наставляла: чтобы он не забыл застегнуть верхнюю пуговицу на пальто,
а то еще продует, и чтобы он осторожно переходил улицу, и чтобы не курил натощак!
Но этот день странным образом оказался полон сюрпризов.
Не успел дядя Юлиус уйти, как фрекен Бок кинулась к телефону.
И она говорила так громко, что Малыш и Карлсон невольно услышали весь ей разговор.
*/

package itmo.ru.main;

import itmo.ru.enums.HearType;
import itmo.ru.enums.HelpType;
import itmo.ru.enums.Instructions;
import itmo.ru.enums.PhoneTypes;
import itmo.ru.other.Day;
import itmo.ru.other.Phone;
import itmo.ru.people.Carlson;
import itmo.ru.people.FrekenBock;
import itmo.ru.people.Julius;
import itmo.ru.people.Kid;

public class Main {

    public static void main(String[] args) {
        FrekenBock frekenBock = new FrekenBock();
        Kid kid = new Kid();
        Carlson carlson = new Carlson();
        Julius julius = new Julius();
        frekenBock.helpToWith(julius, HelpType.PACK_THINGS);
        kid.hear(frekenBock, HearType.INSTRUCTIONS, false);
        carlson.hear(frekenBock, HearType.INSTRUCTIONS, false);
        frekenBock.instructJulius(Instructions.FASTEN_THE_TOP_BUTTON, julius);
        frekenBock.instructJulius(Instructions.CAREFULLY_CROSS_THE_STREET, julius);
        frekenBock.instructJulius(Instructions.DO_NOT_SMOKE_ON_AN_EMPTY_STOMACH, julius);
        Day day = new Day();
        day.setDayFullOfSurprises();
        julius.walkAway(false);
        Phone phone = new Phone(PhoneTypes.PHONE, "newModel");
        frekenBock.walkToPhone(phone, true);
        frekenBock.speakByPhone(true, phone);
        kid.hear(frekenBock, HearType.SPEECH, true);
        carlson.hear(frekenBock, HearType.SPEECH, true);

    }
}
