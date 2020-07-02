package ru.job4j.tracker;

import java.util.Comparator;

public class SortByIdItem implements Comparator<Item> {

    @Override
    public int compare(Item first, Item second) {
        return first.getId() .compareTo(second.getId());
    }
}
