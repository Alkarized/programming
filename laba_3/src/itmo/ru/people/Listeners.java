package itmo.ru.people;

import itmo.ru.abilities.IHear;
import itmo.ru.enums.Gender;
import itmo.ru.enums.HearType;

class Listeners extends AHuman implements IHear {
    @Override
    public void hear(AHuman who, HearType hearType, boolean isInvoluntarily) {
        String gender = getGender().equals(Gender.MALE) ? "услашал" : "услышала";
        String hearInvoluntarily = isInvoluntarily ? " невольно " : " ";
        System.out.println(getName() + hearInvoluntarily + gender + " " + hearType.getWhatType() + " " + who.getName());
    }

    Listeners(String name, int age, Gender gender){
        setName(name);
        setAge(age);
        setGender(gender);
    }

}
