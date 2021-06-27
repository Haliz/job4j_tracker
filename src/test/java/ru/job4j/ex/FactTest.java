package ru.job4j.ex;

import org.junit.Test;

public class FactTest {

    @Test (expected = IllegalArgumentException.class)
    public void whenNegativeNumber() {
        Fact rsl = new Fact();
        rsl.calc(-2);
    }
}
