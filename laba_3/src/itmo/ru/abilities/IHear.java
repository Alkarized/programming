package itmo.ru.abilities;

import itmo.ru.enums.HearType;
import itmo.ru.people.AHuman;

public interface IHear {
    public void hear(AHuman who, HearType hearType, boolean isInvoluntarily);
}
