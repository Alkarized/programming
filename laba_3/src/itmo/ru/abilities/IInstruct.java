package itmo.ru.abilities;

import itmo.ru.enums.Instructions;
import itmo.ru.people.Julius;
import itmo.ru.people.Observers;

public interface IInstruct {
    public void instructJulius(Instructions instruction, Julius who, Observers observers);
}
