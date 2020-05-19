package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (String element : value) {
            rsl++;
            if (element.equals(key)) {
                return rsl;
            }
        }
        throw new ElementNotFoundException("Index not found");
    }

    public static void main(String[] args) {
        try {
            String[] arrow = {"1","2","3"};
            indexOf(arrow,"4");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

    }
}

