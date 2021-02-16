package ru.itmo.collection;

import ru.itmo.fields.Flat;

import java.util.Comparator;

public class CollectionComparator implements Comparator<Flat> {
    @Override
    public int compare(Flat o1, Flat o2) {
        return o1.getName().compareTo(o2.getName())
                /*o1.getName().compareTo(o2.getName()) +
                o1.getCoordinates().getX().compareTo(o2.getCoordinates().getX()) +
                o1.getCoordinates().getY().compareTo(o2.getCoordinates().getY()) +
                o1.getCreationDate().compareTo(o2.getCreationDate()) +
                o1.getArea().compareTo(o2.getArea()) +
                o1.getNumberOfRooms().compareTo(o2.getNumberOfRooms()) +
                o1.getFurnish().compareTo(o2.getFurnish()) +
                o1.getView().compareTo(o2.getView()) +
                o1.getTransport().compareTo(o2.getTransport()) +
                o1.getHouse().getName().compareTo(o2.getHouse().getName()) +
                o1.getHouse().getYear().compareTo(o2.getHouse().getYear()) +
                o1.getHouse().getNumberOfFlatsOnFloor().compareTo(o2.getHouse().getNumberOfFlatsOnFloor())*/;
    }

}
