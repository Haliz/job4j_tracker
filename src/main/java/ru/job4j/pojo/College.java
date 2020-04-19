package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student haliz = new Student();
        haliz.setSurname("Хализев");
        haliz.setName("Игорь");
        haliz.setPatronymic("Николаевич");
        haliz.setGroup("Стажер");
        haliz.setAdmissionDate("09.02.2020");

        System.out.println("ФИО: " + haliz.getSurname() + " "
        + haliz.getName() + " " + haliz.getPatronymic()
        + System.lineSeparator() + "Группа: " + haliz.getGroup()
        + System.lineSeparator() + "Дата поступления: "
        + haliz.getAdmissionDate());
    }
}
