package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    private List<Integer> newList;

    public static EasyStream of(List<Integer> source) {
        EasyStream easyStream = new EasyStream();
        easyStream.newList = List.copyOf(source);
        return easyStream;
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (Integer element : newList) {
           Integer newElement = fun.apply(element);
           arr.add(newElement);
        }
        newList = arr;
     return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (Integer element : newList) {
            if (fun.test(element)) {
                arr.add(element);
            }
        }
        newList = arr;
        return this;
    }

    public List<Integer> collect() {
        return newList;
    }
}