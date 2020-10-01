package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    @Test
    public void listAddressByCity() {
        Address address1 = new Address("Москва", "Тверская", 10, 1);
        Address address2 = new Address("Люберцы", "Смирновская", 5, 10);
        Address address3 = new Address("Воронеж", "Лизюкова", 12, 5);
        Address address4 = new Address("Москва", "Тверская", 10, 2);
        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        Profile profile3 = new Profile(address3);
        Profile profile4 = new Profile(address4);
        List<Profile> profiles = new ArrayList<>();
        Collections.addAll(profiles, profile1, profile2, profile3, profile4);
        List<Address> result = Profiles.collect(profiles);
        List<Address> expected = List.of(address3, address2, address1);
        assertThat(result, is(expected));
    }
}
