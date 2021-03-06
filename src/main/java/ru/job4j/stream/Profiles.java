package ru.job4j.stream;

import ru.job4j.sort.ComparatorByCity;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
    return profiles.stream()
            .map(Profile::getAddress)
            .sorted(new ComparatorByCity())
            .distinct()
            .collect(Collectors.toList());
    }
}
