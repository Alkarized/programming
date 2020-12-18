package ru.itmo.people;

import ru.itmo.abilities.Apologetic;
import ru.itmo.abilities.HeadShakeable;
import ru.itmo.abilities.Taking;
import ru.itmo.enums.Gender;
import ru.itmo.enums.HouseRooms;
import ru.itmo.objects.Box;
import ru.itmo.objects.Newspaper;
import ru.itmo.objects.Things;

import java.util.ArrayList;

public class Kid extends Listeners implements HeadShakeable, Taking, Apologetic {
    private Newspaper newspaper;

    public Kid() {
        super("Малыш",12,Gender.MALE, HouseRooms.FIRST_ROOM);
    }

    //Can add inner Class here.
    @Override
    public void shakeHead(){
        addPerformedActions("Покачал головой");
        System.out.println(getName() + " покачал головой.");
    }

    //If there is no newspaper - EXCEPTION! or he has it already
    @Override
    public void takeNewspaperFromBox(Box box) {
        ArrayList<Things> items = box.getItemsInBox();
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getClass().equals(Newspaper.class)){
                newspaper = (Newspaper) items.get(i);
                box.removeItemsInBox(i);
                addPerformedActions("Взял из ящика стола газету");
                break;
            }
        }
    }

    @Override
    public void isPersonHasNewspaper() {
        if(newspaper == null){
            System.out.println(getName() + " не имеет газеты");
        } else{
            System.out.println(getName() + " имеет газету");
        }

    }


    @Override
    public void apologise(Human whom) {
        addPerformedActions("Оправдывался за свой ответ перед " + whom.getName());
        System.out.println(getName() + " оправдывался за свой ответ перед " + whom.getName());
    }
}
