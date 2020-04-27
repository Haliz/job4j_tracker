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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
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
    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        boolean rls = index != -1;
        if(rls) {
            item.setId(id);
            items[index] = item;
        }
        return rls;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        boolean rls = index != -1;
        if(rls) {
            int start = index + 1;
            int size = this.size - start;
            System.arraycopy(items, start, items, index, size);
            items[this.size - 1] = null;
            this.size--;
        }
        return rls;
    }
}