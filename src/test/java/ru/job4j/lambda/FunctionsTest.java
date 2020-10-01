package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FunctionsTest {
    @Test
    public void whenLinearFunction() {
        List<Double> result = Functions.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = List.of(11D, 13D, 15D, 17D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        List<Double> result = Functions.diapason(5, 8, x -> 2 * Math.pow(x, 2) + 1);
        List<Double> expected = List.of(51D, 73D, 99D, 129D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunction() {
        List<Double> result = Functions.diapason(1, 4, x -> Math.pow(3, x));
        List<Double> expected = List.of(3D, 9D, 27D, 81D);
        assertThat(result, is(expected));
    }
}
