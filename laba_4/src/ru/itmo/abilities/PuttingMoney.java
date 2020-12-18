package ru.itmo.abilities;

import ru.itmo.objects.Coin;
import ru.itmo.people.Kid;

public interface PuttingMoney {
    public void putMoneyInHand(Kid kid, Coin coin, boolean isSilently);
}
