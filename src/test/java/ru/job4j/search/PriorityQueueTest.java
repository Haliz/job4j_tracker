package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        var result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenLowPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("low1", 5));
        queue.put(new Task("low2", 5));
        queue.put(new Task("low3", 5));
        var result = queue.take();
        assertThat(result.getDesc(), is("low1"));
    }

    @Test
    public void whenDownPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("low1", 5));
        queue.put(new Task("middle", 3));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("low2", 5));
        var result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
}