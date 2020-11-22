package itmo.ru.abilities;

import itmo.ru.enums.HelpType;
import itmo.ru.enums.Instructions;
import itmo.ru.other.Phone;
import itmo.ru.people.AHuman;
import itmo.ru.people.Julius;

public interface IActions {
    public void instructJulius(Instructions instruction, Julius who);

    public void helpToWith(AHuman toHuman, HelpType helpType);

    public void speakByPhone(boolean isLoud, Phone phone);

    public void walkToPhone(Phone toPhone, boolean isFast);
}
