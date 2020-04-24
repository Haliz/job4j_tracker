package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(generateId());
        items[size++] = item;
        return item;
    }

    private String generateId() {
        return String.valueOf(ids++);
    }

    public Item findById(String id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId().equals(id)) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
    int sizeNoNull = 0;
    Item[] namesWithoutNull = new Item[size];
        for (int index = 0; index < size; index++) {
            Item names =items[index];
            if (names != null) {
                namesWithoutNull[sizeNoNull] = names;
                sizeNoNull++;
            }
        }
        namesWithoutNull = Arrays.copyOf(namesWithoutNull, sizeNoNull);
        return namesWithoutNull;
    }

    public Item[] findByName(String key) {
        int indexFoundName = 0;
        Item[] foundName = new Item[size];
        for (int index = 0; index < size; index++) {
            Item names =items[index];
            if (names.getName().equals(key)) {
                foundName[indexFoundName] = names;
                indexFoundName++;
            }
        }
        foundName = Arrays.copyOf(foundName, indexFoundName);
        return foundName;
    }
}