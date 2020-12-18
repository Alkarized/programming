package ru.itmo.people;

import ru.itmo.abilities.Leaving;
import ru.itmo.abilities.ShowingInterest;
import ru.itmo.abilities.Walkable;
import ru.itmo.enums.Gender;
import ru.itmo.enums.HouseRooms;
import ru.itmo.enums.HumanView;
import ru.itmo.exceptions.NegativeOrZeroNumberException;
import ru.itmo.objects.Day;
import ru.itmo.objects.Newspaper;
import ru.itmo.other.Thoughts;

public class Julius extends Human implements ShowingInterest, Walkable, Leaving {
    private Day day;
    private HumanView juliusView;
    private boolean isThatNormalViewForHim;
    private boolean isInterestedInNewspaper;
    private boolean isThatStrange;
    private boolean isNeedToGo;
    private Newspaper newspaper;
    private Thoughts juliusThoughts;
    private String homeCity;

    public Julius() {
        setName("Юлиус");
        setAge(45);
        setGender(Gender.MALE);
        setHouseRoom(HouseRooms.FIRST_ROOM);
    }

    public void printJuliusThoughts() {
        if (juliusThoughts == null) {
            throw new NullPointerException("А мыслей-то и нет!");
        } else {
            String busy = juliusThoughts.isBusy() ? "заняты чем-то " : "не заняты чем-то ";
            String pleasant = juliusThoughts.isPleasant() ? "приятным " : "неприятным ";
            String view = isThatNormalViewForHim ? "непривычный" : "привычный";
            System.out.println("Мысли Юлиуса " + busy + pleasant + "потому что у него " + view + " " + getJuliusView().getView());
        }
    }

    public void setJuliusThoughts(Thoughts juliusThoughts) {
        this.juliusThoughts = juliusThoughts;
    }

    public void setInterestedInNewspaper(boolean interestedInNewspaper) {
        isInterestedInNewspaper = interestedInNewspaper;
    }

    public void setThatStrange(boolean thatStrange) {
        isThatStrange = thatStrange;
    }

    @Override
    public void showInterest(Day day, Newspaper newspaper) {
        this.day = day;
        this.newspaper = newspaper;
        String interest = isInterestedInNewspaper ? "не проявил интереса к " : "проявил интерес к ";
        String thisDay = day == null ? " " : " в этот день ";
        String strange = isThatStrange ? "странным образом" : "";
        String output = strange + thisDay + interest + newspaper.getName();
        System.out.println(getName() + " " + output);
        addPerformedActions(output);
    }

    public boolean IsInterestedInNewspaper() {
        return isInterestedInNewspaper;
    }

    public boolean isThatStrange() {
        return isThatStrange;
    }

    public Day getDay() {
        return day;
    }

    public Newspaper getNewspaper() {
        return newspaper;
    }

    public void setView(HumanView humanView, boolean isThatNormalViewForHim) {
        this.juliusView = humanView;
        this.isThatNormalViewForHim = isThatNormalViewForHim;
    }

    public boolean isThatNormalViewForHim() {
        return isThatNormalViewForHim;
    }

    public HumanView getJuliusView() {
        return juliusView;
    }

    @Override
    public void needToWalkTo(String where) {
        this.isNeedToGo = true;
        System.out.println(getName() + " должен идти " + where);
        addPerformedActions("Должен идти" + where);
    }

    public boolean isNeedToGo() {
        return isNeedToGo;
    }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    @Override
    public void leavingToHome(int time, String city) {
        String whatTime;
        if (time <= 0) {
            throw new NegativeOrZeroNumberException();
        } else if (time == 1) {
            whatTime = "час";
        } else {
            whatTime = "несколько часов";
        }
        setHomeCity(city);
        System.out.println(getName() + " уезжает домой через " + whatTime + ", в " + city);
    }
}
