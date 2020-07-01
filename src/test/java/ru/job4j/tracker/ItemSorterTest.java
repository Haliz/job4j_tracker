package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ItemSorterTest {
    @Test
    public void sortId() {
        Item item1 = new Item("Book", "4");
        Item item2 = new Item("Iron", "1");
        Item item3 = new Item("Pen", "2");
        Item item4 = new Item("Apple", "3");
        List<Item> items = Arrays.asList(item1, item2, item3, item4);
        List<Item> exp = Arrays.asList(item2, item3, item4, item1);
        ItemSorter.sortId(items);
        assertThat(exp, is(items));
    }
    @Test
    public void sortIdRevers() {
        Item item1 = new Item("Book", "4");
        Item item2 = new Item("Iron", "1");
        Item item3 = new Item("Pen", "2");
        Item item4 = new Item("Apple", "3");
        List<Item> items = Arrays.asList(item1, item2, item3, item4);
        List<Item> exp = Arrays.asList(item1, item4, item3, item2);
        ItemSorter.sortIdRevers(items);
        assertThat(exp, is(items));
    }

    @Test
    public void sortName() {
        Item item1 = new Item("Book", "4");
        Item item2 = new Item("Iron", "1");
        Item item3 = new Item("Pen", "2");
        Item item4 = new Item("Apple", "3");
        List<Item> items = Arrays.asList(item1, item2, item3, item4);
        List<Item> exp = Arrays.asList(item4, item1, item2, item3);
        ItemSorter.sortName(items);
        assertThat(exp, is(items));
    }

    @Test
    public void sortNameRevers() {
        Item item1 = new Item("Book", "4");
        Item item2 = new Item("Iron", "1");
        Item item3 = new Item("Pen", "2");
        Item item4 = new Item("Apple", "3");
        List<Item> items = Arrays.asList(item1, item2, item3, item4);
        List<Item> exp = Arrays.asList(item3, item2, item1, item4);
        ItemSorter.sortNameRevers(items);
        assertThat(exp, is(items));
    }
}
