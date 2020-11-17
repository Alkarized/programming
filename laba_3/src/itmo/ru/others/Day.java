package itmo.ru.others;

public class Day {
    private boolean isDayFullOfSurprises = false;

    public boolean isDayFullOfSurprises(){
        return isDayFullOfSurprises;
    }

    public void setDayFullOfSurprises(){
        isDayFullOfSurprises = true;
        System.out.println("День оказался полон сюрпризов!");
    }
}
