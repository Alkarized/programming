package itmo.ru.people;

import itmo.ru.enums.Gender;

public abstract class AHuman {
    private String name;
    private int age;
    private Gender gender;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    protected void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean equals(Object o) {
        return ((AHuman) o).getGender().equals(getGender()) &&
                ((AHuman) o).getName().equals(getName()) &&
                ((AHuman) o).getAge() == getAge() &&
                getClass().equals(o.getClass());
    }

    public int hashCode(){
        int hash = 0;
        int gen = getGender().equals(Gender.MALE) ? 1 : 0;
        for (char x: getName().toCharArray()) {
            if(Integer.MAX_VALUE - hash < Character.MAX_VALUE * 75 + 12 + getAge() + gen)
                hash += x*12 + 12 + getAge() + gen;
            else{
                hash -= x*7 + 43 + getAge() + gen;
            }
        }
        return Math.abs(hash) ;
    }

    @Override
    public String toString() {
        return "Это человек по имени: " + getName() + ", пола: " + getGender() + ", возраста: " + getAge();
    }


}
