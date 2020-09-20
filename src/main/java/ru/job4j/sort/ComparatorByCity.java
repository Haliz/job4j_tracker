package ru.job4j.sort;

import ru.job4j.stream.Address;

import java.util.Comparator;

public class ComparatorByCity implements Comparator<Address> {
    @Override
    public int compare(Address o1, Address o2) {
        return o1.getCity().compareTo(o2.getCity());
    }
}
