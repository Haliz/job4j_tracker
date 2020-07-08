package ru.job4j.collection;

import java.util.Comparator;

import static java.lang.Integer.*;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] lefts = left.split("[^0-9]");
        String[] rights = right.split("[^0-9]");
        int numberLeft = parseInt(lefts[0]);
        int numberRight = parseInt(rights[0]);
        return Integer.compare(numberLeft, numberRight);
    }
}
