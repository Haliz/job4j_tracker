package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private int allPatient;
    private int complaint;

    public Dentist(String name, String surname, String education, String birthday, String category, int allPatient, int complaint) {
        super(name, surname, education, birthday, category);
        this.allPatient = allPatient;
        this.complaint = complaint;
    }

    //public Diagnose heal(Patient pacient) { }
}

