package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> filterType) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (filterType.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterBySize(List<Attachment> list) {
        Predicate<Attachment> isPositive = new Predicate<>() {
            @Override
            public boolean test(Attachment att) {
                return att.getSize() > 100;
            }
        };
        return filter(list, isPositive);
    }

    public static List<Attachment> filterByName(List<Attachment> list) {
        Predicate<Attachment> isPositive = new Predicate<>() {
            @Override
            public boolean test(Attachment att) {
                return att.getName().contains("bug");
            }
        };
        return filter(list, isPositive);
    }

    public static void main(String[] args) {
        List<Attachment> list = new ArrayList<>();
        list.add(new Attachment("one", 10));
        list.add(new Attachment("bug", 101));
        list.add(new Attachment("apple", 520));
        list.add(new Attachment("bug", 20));
        System.out.println(filterBySize(list));
        System.out.println(filterByName(list));
    }
}
