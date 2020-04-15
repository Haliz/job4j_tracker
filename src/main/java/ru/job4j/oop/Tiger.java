package ru.job4j.oop;

public class Tiger extends Predator {
    public Tiger() {
        super();
        System.out.println("load Tiger");
    }

    public Tiger(String name) {
        super(name);
    }

    public static void main(String[] args) {
        Tiger example3 = new Tiger("RRRRR");
        System.out.println("tiger names is " + example3.name);
    }
}
