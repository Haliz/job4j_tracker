package ru.job4j.inheritance;

public class Patient {
    private String name;
    private String surname;
    private String birthday;
    private Diagnose diagnose;

    public Patient (String name, String surname, String education, String birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

}
