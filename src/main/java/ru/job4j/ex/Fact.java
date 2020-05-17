package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        Fact rsl = new Fact();
        System.out.println("factorial n= " + rsl.calc(2) );
    }

    public int calc(int n) {
        if (n<0) {
            throw new IllegalArgumentException("The argument can't be negative");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
