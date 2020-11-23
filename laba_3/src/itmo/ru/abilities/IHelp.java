package itmo.ru.abilities;

import itmo.ru.enums.HelpType;
import itmo.ru.people.AHuman;

public interface IHelp {
    public void helpToWith(AHuman toHuman, HelpType helpType);
}
