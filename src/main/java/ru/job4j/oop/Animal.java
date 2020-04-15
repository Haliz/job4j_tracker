package ru.job4j.oop;

public class Animal {
    String name;

    public Animal() {
        super();
        System.out.println("load Animal");
    }

    public Animal(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Animal example1 = new Animal();
    }
}

