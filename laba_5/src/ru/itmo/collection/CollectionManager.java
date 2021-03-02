package ru.itmo.collection;

import ru.itmo.collection.comparators.CoordinatesComparator;
import ru.itmo.collection.comparators.NameComparator;
import ru.itmo.collection.comparators.NumberOfRoomsComparator;
import ru.itmo.fields.Flat;
import ru.itmo.utils.FlatMaker;
import ru.itmo.utils.Messages;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Главный класс для работы с коллекцией
 */
public class CollectionManager {
    private final File file;
    private final PriorityQueue<Flat> collection;
    private final Date date;

    /**
     * Конструкотор.
     * @param fileName название CSV файла, который будет считыватся для дальнейших действий
     */
    public CollectionManager(String fileName) {
        this.file = new File(fileName);
        collection = new PriorityQueue<>(new NameComparator());
        date = new Date();
    }

    /**
     * Возвращает коллекцию
     * @return коллекция
     */
    public PriorityQueue<Flat> getCollection() {
        return collection;
    }

    /**
     * Метод - вывод информации об коллекции, команда info
     */
    public void printInfoAboutCollection() {
        Messages.normalMessageOutput("Тип коллекции - " + getCollection().getClass().getName() + "\n" +
                "Дата иницализации - " + getDate() + "\n" +
                "Кол-во элементов - " + getCollection().size());

    }

    /**
     * Геттер для файла
     * @return файл
     */
    public File getFile() {
        return file;
    }

    /**
     * Геттер даты
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Очистить коллекцию
     * @return true / false, если размер коллекции больше 0
     */
    public boolean clearCollection() {
        if (getCollection().size() > 0) {
            IdManager.clearSet();
            getCollection().clear();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Сортирует коллекцию
     * @param comp компаратор для сортировки
     * @return новую отсортировоннуб коллекцию
     */
    public PriorityQueue<Flat> sortCollectionByComp(Comparator<Flat> comp) {
        List<Flat> newList = new ArrayList<>(collection);
        newList.sort(comp);
        PriorityQueue<Flat> newCollection = new PriorityQueue<>(comp);
        newCollection.addAll(newList);
        return newCollection;
    }

    /**
     * Выводит первый объект коллекции
     * @return true / false, если размер коллекции больше 0
     */
    public boolean getHeadOfCollection() {
        if (getCollection().size() > 0) {
            Objects.requireNonNull(getCollection().peek()).printInfoAboutElement();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Реализация команды count_less
     * @param number число, которое мы сравниваем в реализации
     * @return -1, если размер коллекции меньше 0, count - кол-во элементов, у которых поле NumberOfRooms меньше
     */
    public int countLessNumberOfRooms(int number) {
        if (getCollection().size() > 0) {
            int count = 0;
            PriorityQueue<Flat> newQueue = new PriorityQueue<>(getCollection());
            while (newQueue.size() > 0) {
                if (newQueue.poll().getNumberOfRooms() < number) {
                    count++;
                }
            }
            return count;
        } else {
            return -1;
        }
    }

    /**
     * Реализация метода min_by_coordinates
     * @return true / false, если размер коллекции больше 0
     */
    public boolean findElementWithMinCoordinates() {
        if (getCollection().size() > 0) {
            PriorityQueue<Flat> queue = sortCollectionByComp(new CoordinatesComparator());
            Objects.requireNonNull(queue.peek()).printInfoAboutElement();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Реалицаия команды print_field_descending_number_of_rooms
     * @return true / false, если размер коллекции больше 0
     */
    public boolean printFieldDescendingNumberOfRooms() {
        if (getCollection().size() > 0) {
            PriorityQueue<Flat> queue = sortCollectionByComp(new NumberOfRoomsComparator());
            Messages.normalMessageOutput("Значения поля numberOfRooms всех элементов в порядке убывания:");
            queue.forEach((flat -> System.out.print(flat.getNumberOfRooms() + " ")));
            System.out.println();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Реализация команды remove_by_id
     * @param id удаление по этому id
     * @return true/false если команда выполнилась верно
     */
    public boolean removeElementById(Long id) {
        if (getCollection().size() > 0) {
            if (!IdManager.checkUniq(id)) {
                getCollection().removeIf(flat -> flat.getId().equals(id));
                IdManager.removeUsedId(id);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Реализация команды remove_first
     * @return true/false если команда выполнилась верно
     */
    public boolean removeFirstElement() {
        if (getCollection().size() > 0) {
            IdManager.removeUsedId(Objects.requireNonNull(getCollection().poll()).getId());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Реализация команды remove_first
     * @return true/false если команда выполнилась верно
     */
    public boolean printAllElements() {
        if (getCollection().size() > 0) {
            getCollection().forEach((Flat::printInfoAboutElement));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Реализация команды add
     * @param arg данные аргумента, идущии вместе с add
     * @param scanner Сканнер
     * @return true / false, если выполнилось добавление элемента
     */
    public boolean addElement(String arg, Scanner scanner) {
        Flat flat = new FlatMaker().makeFlat(arg, scanner);
        if (flat != null) {
            flat.setId(IdManager.findUniq(Math.abs(new Random().nextLong())));
            getCollection().add(flat);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Реализация команды update
     * @param id id по которому идет обновление элемента
     * @param arg данные аргумента, идущии вместе с update
     * @param scanner Сканнер
     * @return true / false, если выполнилось обновление элемента коллекции
     */
    public boolean updateElement(Long id, String arg, Scanner scanner) {
        Flat flat;
        if (!IdManager.checkUniq(id) && getCollection().size() > 0 && (flat = new FlatMaker().makeFlat(arg, scanner)) != null) {
            PriorityQueue<Flat> queue = new PriorityQueue<>(new NameComparator());
            while (!getCollection().peek().getId().equals(id)) {
                queue.add(getCollection().poll());
            }
            try {
                flat.setCreationDate(new SimpleDateFormat("HH:mm:ss.SSS dd-MM-yyyy").parse(getCollection().poll().getCreationDate()));
            } catch (ParseException e) {
                Messages.errorMessageOutput("Какая-то проблема с датой ?");
                return false;
            }

            flat.setId(id);
            getCollection().add(flat);
            while (queue.size() > 0) {
                getCollection().add(queue.poll());
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * Реализация команды remove_lower
     * @param arg данные аргумента, идущии вместе с remove_lower
     * @param scanner Сканнер
     * @return true / false, если выполнилось удаление элементов коллекции
     */
    public boolean removeLower(String arg, Scanner scanner) {
        Flat flat;
        if (getCollection().size() > 0) {
            if ((flat = new FlatMaker().makeFlat(arg, scanner)) != null) {
                try {
                    while (true) {
                        if (getCollection().size() > 0 && getCollection().peek().compareTo(flat) < 0) {
                            IdManager.removeUsedId(getCollection().poll().getId());
                        } else {
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            } else {
                Messages.errorMessageOutput("Не удалось получить элемент для сравнения.");
                return false;
            }
        } else {
            Messages.errorMessageOutput("В коллекции нет элементов, нечего удалять");
            return false;
        }
        Messages.normalMessageOutput("Все элементы, меньше данного - удалены!");
        return true;
    }

}
