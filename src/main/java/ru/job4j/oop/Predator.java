package ru.job4j.oop;

public class Predator extends Animal {
    public Predator() {
        super();
        System.out.println("load Predator");
    }

    public Predator (String name) {
        super(name);
    }

    public static void main(String[] args) {
        Predator example2 = new Predator();
    }
}
