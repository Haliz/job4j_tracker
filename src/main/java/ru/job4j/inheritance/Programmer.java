package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String computerLanguage;

    public Programmer (String name, String surname, String education, String birthday, String technicalSkill, String computerLanguage) {
     super(name, surname, education, birthday, technicalSkill);
     this.computerLanguage = computerLanguage;
    }

    public Programm programm (technicalProject) {}
}
