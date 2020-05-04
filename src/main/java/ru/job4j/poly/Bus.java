package ru.job4j.poly;

public class Bus implements Transport {
    private int capacity;
    private double fuel;
    private double speed;

    @Override
    public void go() {
        double time = 50;
        double distance = time * speed;
    }

    @Override
    public void passengers(int numPassengers) {
        int numberOfTrips = 10;
               int sumPassengers = numPassengers * numberOfTrips;
    }

    @Override
    public double toFill(int fuel) {
        double price = 2.5;
        return  price * fuel;
    }
}
