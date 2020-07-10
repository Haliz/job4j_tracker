package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String category;

    public Doctor(String name, String surname, String education, String birthday, String category) {
        super(name, surname, education, birthday);
        this.category = category;
    }
    // public Diagnose diagnostics(String illness, String analyzes, String inspection) {   }
}
