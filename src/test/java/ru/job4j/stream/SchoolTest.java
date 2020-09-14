package ru.job4j.stream;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void whenGroup10A() {
        Student student1 = new Student( "Garry", 50);
        Student student2 = new Student( "Mikael", 80);
        Student student3 = new Student( "Marya", 100);
        Student student4 = new Student( "Ivan", 30);
        Student student5 = new Student( "Dimon", 20);
        List<Student> students = new ArrayList<>();
        Collections.addAll(students, student1, student2, student3,
                student4, student5);
        List<Student> result = School.group10A(students);
        List<Student> expected = Arrays.asList(student2, student3);
        assertThat(result, is(expected));
    }

    @Test
    public void whenGroup10B() {
        Student student1 = new Student( "Garry", 50);
        Student student2 = new Student( "Mikael", 80);
        Student student3 = new Student( "Marya", 100);
        Student student4 = new Student( "Ivan", 30);
        Student student5 = new Student( "Dimon", 20);
        List<Student> students = new ArrayList<>();
        Collections.addAll(students, student1, student2, student3,
                student4, student5);
        List<Student> result = School.group10B(students);
        List<Student> expected = Arrays.asList(student1);
        assertThat(result, is(expected));
    }

    @Test
    public void whenGroup10V() {
        Student student1 = new Student( "Garry", 50);
        Student student2 = new Student( "Mikael", 80);
        Student student3 = new Student( "Marya", 100);
        Student student4 = new Student( "Ivan", 30);
        Student student5 = new Student( "Dimon", 20);
        List<Student> students = new ArrayList<>();
        Collections.addAll(students, student1, student2, student3,
                student4, student5);
        List<Student> result = School.group10V(students);
        List<Student> expected = Arrays.asList(student4, student5);
        assertThat(result, is(expected));
    }
}
