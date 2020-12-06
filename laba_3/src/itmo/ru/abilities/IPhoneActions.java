package itmo.ru.abilities;

import itmo.ru.other.Phone;
import itmo.ru.people.Observers;

public interface IPhoneActions {
    public void walkToPhone(Phone toPhone, boolean isFast);
    public void speakByPhone(boolean isLoud, Phone phone, String text, Observers observers);
}
