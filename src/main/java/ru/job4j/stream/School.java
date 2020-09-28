package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    public static List <Student> collect(List <Student> students, Predicate <Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    public static List <Student> group10A(List <Student> students) {
        Predicate<Student> predicate = student -> student.getScore() >= 70
               && student.getScore() <= 100;
        return School.collect(students, predicate);
    }

    public static List <Student> group10B(List <Student> students) {
        Predicate<Student> predicate = student -> student.getScore() >= 50
                && student.getScore() < 70;
        return School.collect(students, predicate);
    }

    public static List <Student> group10V(List <Student> students) {
        Predicate<Student> predicate = student -> student.getScore() > 0
                && student.getScore() < 50;
        return School.collect(students, predicate);
    }

    public static Map <String, Student> listOfStudentToMap(List <Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getSurname, e -> e, (e1, e2) -> e1));
    }
}
