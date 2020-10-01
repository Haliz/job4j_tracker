package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class IntegerListTest {
    @Test
    public void listFromMatrix() {
        Integer[][] matrix = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };
        List<Integer> expected = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> result = IntegerList.collect(matrix);
        assertThat(result, is(expected));
    }
}
