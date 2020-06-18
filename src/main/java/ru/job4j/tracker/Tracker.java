package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        items.add(item);
        item.setId(generateId());
         return item;
    }

    private String generateId() {
        return String.valueOf(ids++);
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> foundName = new ArrayList<>();
        for (Item search : items) {
            if (search.getName().equals(key)) {
                foundName.add(search);
            }
        }
        return foundName;
    }
    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        boolean rls = index != -1;
        if(rls) {
            item.setId(id);
            items.set(index, item);
        }
        return rls;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (Item search : items ) {
            if (search.getId().equals(id)) {
                rsl = items.indexOf(search);
                break;
            }
        }
        return rsl;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        boolean rls = index != -1;
        if(rls) {
            items.remove(index);
        }
        return rls;
    }
}