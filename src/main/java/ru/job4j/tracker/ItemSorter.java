package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemSorter {

    public static void sortId(List<Item> items) {
        Collections.sort(items);
    }

    public static void sortIdRevers(List<Item> items) {
        items.sort(Collections.reverseOrder());
    }

    public static void sortName(List<Item> items) {
        items.sort(new SortByNameItem());
    }
    public static void sortNameRevers(List<Item> items) {
        items.sort(new SortByNameItemRevers());
    }
}
