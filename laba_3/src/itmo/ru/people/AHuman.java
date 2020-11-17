package itmo.ru.people;

import itmo.ru.enumobjs.Gender;

public abstract class AHuman {
    private String name;
    private Gender gender;

    public String getName(){
        return name;
    }

    public void setName(String name){
        if(name == null){
            this.name = "Вася Пупкин";
        } else {
            this.name = name;
        }
    }

    public Gender getGender(){
        return gender;
    }

    public void setGender(Gender gender){
        if(gender == null) {
            this.gender = Gender.MALE;
        } else{
            this.gender = gender;
        }
    }

    public AHuman(String name, Gender gender) {
        setGender(gender);
        setName(name);
    }

    public AHuman(Gender gender) {
        setGender(gender);
        setName(null);
    }

    public AHuman(String name) {
        setName(name);
        setGender(null);
    }

    public AHuman(){
        setName(null);
        setGender(null);
    }

    @Override
    public String toString() {
        String gender = getGender().equals(Gender.MALE) ? "Мужскго" : "Женского";
        return "Человек по имени " + getName() + ", пола " + getGender();
    }

    @Override
    public boolean equals(Object o) {
        return getName().equals(((AHuman)o).getName())
                && getGender().equals(((AHuman)o).getGender());
    }

}
