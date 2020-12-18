package ru.itmo.abilities;

import ru.itmo.objects.Phone;
import ru.itmo.people.Observers;

public interface PhoneActions {
    public void walkToPhone(Phone phone, boolean isFast);
    public void speakByPhone(boolean isLoud, Phone phone, String text, Observers observers);
}
