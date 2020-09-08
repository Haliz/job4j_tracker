package ru.job4j.sort;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortInteger {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Collections.addAll(arr, 0, 1, -2, 3, -4, 10);
        List<Integer> positive = arr.stream().filter(elem -> elem > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
