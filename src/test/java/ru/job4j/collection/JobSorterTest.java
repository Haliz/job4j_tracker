package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobSorterTest {
    @Test
    public void sortByName() {
        JobByName comp = new JobByName();
        Job job1 = new Job("Read", 1);
        Job job2 = new Job("Debug", 2);
        assertThat(comp.compare(job1, job2), greaterThan(0));
    }

    @Test
    public void sortByNameRevers() {
        JobByNameRevers comp = new JobByNameRevers();
        Job job1 = new Job("Read", 1);
        Job job2 = new Job("Debug", 2);
        assertThat(comp.compare(job1, job2), lessThan(0));
    }

    @Test
    public void sortByPriority() {
        JobByPriority comp = new JobByPriority();
        Job job1 = new Job("Read", 1);
        Job job2 = new Job("Debug", 2);
        assertThat(comp.compare(job1, job2), lessThan(0));
    }
    @Test
    public void sortByPriorityRevers() {
        JobByPriorityRevers comp = new JobByPriorityRevers();
        Job job1 = new Job("Read", 1);
        Job job2 = new Job("Debug", 2);
        assertThat(comp.compare(job1, job2), greaterThan(0));
    }

    @Test
    public void sortByNameAndPriority() {
        Job job1 = new Job("Write", 1);
        Job job2 = new Job("Debug", 2);
        Job job3 = new Job("Write", 3);
        List<Job> jobs = Arrays.asList(job1, job2, job3);
        List<Job> exp = List.of(job2, job1, job3);
        JobSorter.byNameAndPriorityRise(jobs);
        assertThat(exp, is(jobs));
    }

    @Test
    public void sortByNameAndPriorityRevers() {
        Job job1 = new Job("Write", 1);
        Job job2 = new Job("Debug", 2);
        Job job3 = new Job("Write", 3);
        List<Job> jobs = Arrays.asList(job1, job2, job3);
        List<Job> exp = List.of(job2, job3, job1);
        JobSorter.byNameAndPriorityDecrease(jobs);
        assertThat(exp, is(jobs));
    }

    @Test
    public void sortByPriorityAndName() {
        Job job1 = new Job("Write", 1);
        Job job2 = new Job("Debug", 1);
        Job job3 = new Job("Write", 3);
        List<Job> jobs = Arrays.asList(job1, job2, job3);
        List<Job> exp = List.of(job2, job1, job3);
        JobSorter.byPriorityAndNameRise(jobs);
        assertThat(exp, is(jobs));
    }

    @Test
    public void sortByPriorityAndNameRevers() {
        Job job1 = new Job("Read", 2);
        Job job2 = new Job("Debug", 1);
        Job job3 = new Job("Write", 1);
        List<Job> jobs = Arrays.asList(job1, job2, job3);
        List<Job> exp = List.of(job3, job2, job1);
        JobSorter.byPriorityAndNameDecrease(jobs);
        assertThat(exp, is(jobs));
    }
}
