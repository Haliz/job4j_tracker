package ru.job4j.oop;

public class StudentOld {

    public void music() {
        System.out.println("Tra tra tra");
    }

    public void song() {
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {
        StudentOld petya = new StudentOld();
        for (int i = 1; i <= 3; i++) {
            petya.music();
            petya.song();
            System.out.println();
        }
    }
}
