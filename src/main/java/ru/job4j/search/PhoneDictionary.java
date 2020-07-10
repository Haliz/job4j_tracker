package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person search : persons) {
            if (
                    search.getName().contains(key)
                            || search.getSurname().contains(key)
                            || search.getPhone().contains(key)
                            || search.getAddress().contains(key)
                ) {
                result.add(search);
            }
        }
        return result;
    }
}
