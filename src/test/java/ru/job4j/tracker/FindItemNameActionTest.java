package ru.job4j.tracker;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindItemNameActionTest {
    @Test
    public void whenCheckOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        FindItemNameAction act = new FindItemNameAction();
        act.execute(new StubInput(new String[] {item.getName()}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Item{id ='" + item.getId() + "', name ='"+ item.getName() +"'}")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
