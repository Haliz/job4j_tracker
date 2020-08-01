package ru.job4j.others;

public class Merge {
    public static int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int i = 0, j = 0;
        for (int k = 0; k < rsl.length; k++) {
             if (i < left.length && j < right.length) {
                 if (left[i] <= right[j]) {
                     rsl[k] = left[i];
                     i++;
                 } else {
                     rsl[k] = right[j];
                     j++;
                 }
             } else if (i == left.length) {
                 rsl[k] = right[j];
                 j++;
             } else if (j == right.length) {
                 rsl[k] = left[i];
                 i++;
             }
        }
        return rsl;
    }
}
