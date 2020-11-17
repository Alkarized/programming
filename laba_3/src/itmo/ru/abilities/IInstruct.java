package itmo.ru.abilities;

import itmo.ru.enumobjs.Instructions;
import itmo.ru.people.AHuman;
import itmo.ru.people.Julius;

public interface IInstruct {
    public void instructJulius(Instructions instruction, Julius who);
}
