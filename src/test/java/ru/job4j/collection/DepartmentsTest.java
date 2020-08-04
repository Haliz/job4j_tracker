package ru.job4j.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenMissedK2() {
        List<String> input = Arrays.asList("k1/sk1", "k2", "k2/sk1/ssk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1", "k2", "k2/sk1", "k2/sk1/ssk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void sortAscTest() {
        List<String> input = Arrays.asList("k2/sk1/ssk1", "k1/sk1/ssk2", "k2/sk1", "k1/sk1/ssk1", "k1/sk1",
                "k2/sk1/ssk2", "k1/sk2", "k1", "k2");
        List<String> expect = Arrays.asList("k1", "k1/sk1", "k1/sk1/ssk1", "k1/sk1/ssk2", "k1/sk2",
                "k2", "k2/sk1", "k2/sk1/ssk1", "k2/sk1/ssk2");
        Departments.sortAsc(input);
        assertThat(input, is(expect));
    }

    @Test
    public void sortDescTest() {
        List<String> input = Arrays.asList("k2/sk1/ssk1", "k1/sk1/ssk2", "k2/sk1", "k1/sk1/ssk1", "k1/sk1",
                "k2/sk1/ssk2", "k1/sk2", "k1", "k2");
        List<String> expect = Arrays.asList("k2", "k2/sk1", "k2/sk1/ssk1", "k2/sk1/ssk2",
                "k1", "k1/sk1", "k1/sk1/ssk1", "k1/sk1/ssk2", "k1/sk2");
        Departments.sortDesc(input);
        assertThat(input, is(expect));
    }

    @Test
    public void sortDescFullCycle() {
        List<String> input = Arrays.asList("k2/sk1/ssk1", "k1/sk1/ssk2",  "k1/sk1/ssk1",
                "k2/sk1/ssk2" );
        List<String> expect = Arrays.asList("k2", "k2/sk1", "k2/sk1/ssk1", "k2/sk1/ssk2",
                "k1", "k1/sk1", "k1/sk1/ssk1", "k1/sk1/ssk2");
        List<String> allDeps = Departments.fillGaps(input);
        Departments.sortDesc(allDeps);
        assertThat(allDeps, is(expect));
    }
}
