package ru.job4j.inheritance;

public class Builder extends Engineer {

    private String structuresType;

    public Builder(String name, String surname, String education, String birthday, String technicalSkill, String structuresType) {
     super(name, surname, education, birthday, technicalSkill);
     this.structuresType = structuresType;
    }

    // public Build build (Project) {}
}
