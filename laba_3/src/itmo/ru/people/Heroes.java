package itmo.ru.people;

import itmo.ru.abilities.IHear;
import itmo.ru.enumobjs.Gender;
import itmo.ru.enumobjs.HearType;

public class Heroes extends AHuman implements IHear {
    @Override
    public void hear(AHuman who, HearType what, boolean isBySelf) {
        String gender = getGender().equals(Gender.MALE) ? "услашал" : "услышала";
        String whatType = what.equals(HearType.INSTRUCTIONS) ? "наставления" : "разговор";
        String hearBySelf = isBySelf ? " " : " невольно ";
        System.out.println(getName() + hearBySelf + gender + " " + whatType + " " + who.getName());
    }

    public Heroes(String name) {
        super(name);
    }

    public Heroes(String name, Gender gender) {
        super(name, gender);
    }

    public Heroes(Gender gender){
        super(gender);
    }

    public Heroes() {
        super();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (char x: getName().toCharArray()) {
            if(Integer.MAX_VALUE - hash < Character.MAX_VALUE * 75 + 12)
                hash += x*75 + 12;
            else{
                hash -= x*23 + 43;
            }
        }
        return hash;
    }
}
