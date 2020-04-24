package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void checkFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Саша");
        tracker.add(item1);
        Item item2 = new Item("Ваня");
        tracker.add(item2);
        Item item3 = new Item("Вася");
        tracker.add(item3);
        Item [] exp = {item1, item2, item3};
        assertThat(exp, is(tracker.findAll()));
    }

    @Test
    public void checkFindName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Саша");
        tracker.add(item1);
        Item item2 = new Item("Ваня");
        tracker.add(item2);
        Item item3 = new Item("Вася");
        tracker.add(item3);
        Item [] exp = {item2};
        assertThat(exp, is(tracker.findByName("Ваня")));
    }
}