package itmo.ru.abilities;

import itmo.ru.enums.Instructions;
import itmo.ru.people.Julius;

public interface IInstruct {
    public void instructJulius(Instructions instruction, Julius who);
}
