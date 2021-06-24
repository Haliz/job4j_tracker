package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("test1");
        memTracker.add(item);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

        @Test
    public void checkFindAll() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("Саша");
        memTracker.add(item1);
        Item item2 = new Item("Ваня");
        memTracker.add(item2);
        Item item3 = new Item("Вася");
        memTracker.add(item3);
        List<Item> exp = List.of(item1, item2, item3);
        assertThat(exp, is(memTracker.findAll()));
    }

    @Test
    public void checkFindName() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("Саша");
        memTracker.add(item1);
        Item item2 = new Item("Ваня");
        memTracker.add(item2);
        Item item3 = new Item("Вася");
        memTracker.add(item3);
        List<Item> exp = new ArrayList<>();
        exp.add(item2);
        assertThat(exp, is(memTracker.findByName("Ваня")));
    }

    @Test
    public void whenReplace() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        memTracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        memTracker.replace(id, bugWithDesc);
        assertThat(memTracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        memTracker.add(bug);
        String id = bug.getId();
        memTracker.delete(id);
        assertThat(memTracker.findById(id), is(nullValue()));
    }
}