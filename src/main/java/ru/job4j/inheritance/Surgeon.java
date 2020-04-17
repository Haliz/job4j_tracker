package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private int recovered;
    private int dead;

    public Surgeon (String name, String surname, String education, String birthday, String category, int recovered, int dead) {
        super(name, surname, education, birthday, category);
        this.recovered = recovered;
        this.dead = dead;
    }

    public Diagnose heal(Patient pacient) { }
}

