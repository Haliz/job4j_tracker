package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 40)
        );
        Comparator comparator = (o1, o2) -> {
            Attachment left = (Attachment) o1;
            Attachment right = (Attachment) o2;
            return right.getSize() - left.getSize();
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        Comparator<Attachment> comparatorName = (o1, o2) -> o2.getName().compareTo(o1.getName());
        attachments.sort(comparatorName);
        System.out.println();
        System.out.println(attachments);
    }
}
