package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemSorter {

    public static void sortId(List<Item> items) {
        items.sort(new SortByIdItem());
    }

    public static void sortIdRevers(List<Item> items) {
        items.sort(new SortByIdItemRevers());
    }

    public static void sortName(List<Item> items) {
        items.sort(new SortByNameItem());
    }
    public static void sortNameRevers(List<Item> items) {
        items.sort(new SortByNameItemRevers());
    }
}
