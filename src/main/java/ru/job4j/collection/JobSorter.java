package ru.job4j.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorter {

    public static void byNameAndPriorityRise(List<Job> jobs) {
        Comparator<Job> comb = new JobByName()
                .thenComparing(new JobByPriority());
        Collections.sort(jobs, comb);
    }

    public static void byNameAndPriorityDecrease(List<Job> jobs) {
        Comparator<Job> comb = new JobByName()
                .thenComparing(new JobByPriorityRevers());
        Collections.sort(jobs, comb);
    }

    public static void byPriorityAndNameRise(List<Job> jobs) {
        Comparator<Job> comb = new JobByPriority()
                .thenComparing(new JobByName());
        Collections.sort(jobs, comb);
    }

    public static void byPriorityAndNameDecrease(List<Job> jobs) {
        Comparator<Job> comb = new JobByPriority()
                .thenComparing(new JobByNameRevers());
        Collections.sort(jobs, comb);
    }
}
