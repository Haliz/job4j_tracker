package ru.job4j.tracker.ex;

import org.junit.Test;
import ru.job4j.ex.Fact;

public class FactTest {

    @Test (expected = IllegalArgumentException.class)
    public void whenNegativeNumber() {
        Fact rsl = new Fact();
        rsl.calc(-2);
    }
}
