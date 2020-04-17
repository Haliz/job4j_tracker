package ru.job4j.inheritance;

public class Engineer extends Profession {
    private String technicalSkill;

    public Engineer (String name, String surname, String education, String birthday, String technicalSkill) {
        super(name, surname, education, birthday);
        this.technicalSkill = technicalSkill;
    }

    public String getTechnicalSkill() {
        return  technicalSkill;
    }
}
