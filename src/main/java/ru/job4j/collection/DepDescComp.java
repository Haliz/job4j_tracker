package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] string1 = o1.split("/");
        String[] string2 = o2.split("/");
        int rsl = string2[0].compareTo(string1[0]);
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}
