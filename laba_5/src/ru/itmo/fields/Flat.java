package ru.itmo.fields;

import ru.itmo.utils.Messages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class Flat {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long area; //Значение поля должно быть больше 0
    private Integer numberOfRooms; //Значение поля должно быть больше 0
    private Furnish furnish; //Поле не может быть null
    private View view; //Поле не может быть null
    private Transport transport; //Поле не может быть null
    private House house; //Поле не может быть nul

    public Flat() {
        this.creationDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (name == null || name.equals("")) {
            return false;
        } else {
            this.name = name;
            return true;
        }
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public boolean setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
        return true;
    }

    public String getCreationDate() {
        return new SimpleDateFormat("yyyy-MM-dd;HH:mm:ss.SSS").format(creationDate);
        //return creationDate;
    }

    public Long getArea() {
        return area;
    }

    public boolean setArea(Long area) {
        if (area > 0) {
            this.area = area;
            return true;
        } else {
            return false;
        }
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public boolean setNumberOfRooms(Integer numberOfRooms) {
        if (numberOfRooms > 0) {
            this.numberOfRooms = numberOfRooms;
            return true;
        } else {
            return false;
        }
    }

    public Furnish getFurnish() {
        return furnish;
    }

    public boolean setFurnish(Furnish furnish) {
        if (furnish == null) {
            return false;
        } else {
            this.furnish = furnish;
            return true;
        }
    }

    public View getView() {
        return view;
    }

    public boolean setView(View view) {
        if (view == null) {
            return false;
        } else {
            this.view = view;
            return true;
        }
    }

    public Transport getTransport() {
        return transport;
    }

    public boolean setTransport(Transport transport) {
        if (transport == null) {
            return false;
        } else {
            this.transport = transport;
            return true;
        }
    }

    public House getHouse() {
        return house;
    }

    public boolean setHouse(House house) {
        this.house = house;
        return true;
    }

    public void printInfoAboutElement() {
        Messages.normalMessageOutput("Id - " + id + "\n" +
                "Имячко - " + name + "\n" +
                "Координаты x и y - " + coordinates.getX() + " " + coordinates.getY() + "\n" +
                "Дата создания - " + getCreationDate() + "\n" +
                "Ариа - " + area + "\n" +
                "Кол-во комнат - " + numberOfRooms + "\n" +
                "Отделка - " + furnish + "\n" +
                "Вид - " + view + "\n" +
                "Транспорт - " + transport + "\n" +
                "Имя дома - " + house.getName() + "\n" +
                "Год дома - " + house.getYear() + "\n" +
                "Кол-во квартир на этаже - " + house.getNumberOfFlatsOnFloor());
    }

    public boolean setId(Long id) {
        if (id != null && id > 0) {
            this.id = Uniq.findUniq(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean setCreationDate(Date creationDate) {
        if (creationDate == null) {
            return false;
        } else {
            this.creationDate = creationDate;
            return true;
        }
    }

    /*public Flat(Long id, String name, Coordinates coordinates, Date creationDate, Long area, Integer numberOfRooms, Furnish furnish, View view, Transport transport, House house) {
        setId(id);
        setName(name);
        setCoordinates(coordinates);
        setCreationDate(creationDate);
        setArea(area);
        setNumberOfRooms(numberOfRooms);
        setFurnish(furnish);
        setView(view);
        setTransport(transport);
        setHouse(house);
    }*/

    /*public Flat(String name, Coordinates coordinates, Long area, Integer numberOfRooms, Furnish furnish, View view, Transport transport, House house) {
        this();
        setName(name);
        setCoordinates(coordinates);
        setArea(area);
        setNumberOfRooms(numberOfRooms);
        setFurnish(furnish);
        setView(view);
        setTransport(transport);
        setHouse(house);
    }*/

    public void removeUsedId(Long id) {
        Uniq.remId(id);
    }

    public boolean checkIdUniq(Long id) {
        return Uniq.checkUniq(id);

    }

    public static void clearSet() {
        Uniq.hashSet.clear();
    }

    private static class Uniq {
        private static HashSet<Long> hashSet = new HashSet<>();

        private static boolean checkUniq(Long id) {
            return !hashSet.contains(id);
        }

        private static Long findUniq(Long id) {
            if (checkUniq(id)) {
                Uniq.hashSet.add(id);
                return id;
            } else {
                return findUniq((long) Math.floor(Math.random() * 999999998) + 1);
            }
        }

        private static void remId(Long id) {
            hashSet.remove(id);
        }


    }
}



