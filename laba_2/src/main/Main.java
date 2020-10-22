package main;

import pokemons.*;
import ru.ifmo.se.pokemon.*;

public class Main {

    public static void main(String[] args) {
        Battle battle = new Battle();
        battle.addAlly(new Ferroseed("JABA",1));
        battle.addAlly(new Vikavolt("Grover", 4));
        battle.addAlly(new Grubbin("GOD", 2));
        battle.addFoe(new Ferrothorn("sqc", 2));
        battle.addFoe(new Charjabug("Pepega", 3));
        battle.addFoe(new Giratina("Pupa", 2));
        battle.go();

    }
}
