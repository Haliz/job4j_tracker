package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("CODE",800);
        Book book2 = new Book("Изучаем JAVA",700);
        Book book3 = new Book("Clean code", 1000);
        Book book4 = new Book("Clean code", 500);

        Book[] library = new Book[4];
        library[0] = book1;
        library[1] = book2;
        library[2] = book3;
        library[3] = book4;

        for (Book lib : library) {
            System.out.println("Книга: " + lib.getName() + " - " + lib.getPages() + " страниц");
        }

        System.out.println(System.lineSeparator() + "Replace 1 and 4 books:");
        Book temp = library [0];
        library[0] = library [3];
        library[3] = temp;

        for (Book lib : library) {
            System.out.println("Книга: " + lib.getName() + " - " + lib.getPages() + " страниц");
        }

        System.out.println(System.lineSeparator());
        String targetName = "Clean code";
        for (int index = 0; index < library.length; index++) {
            Book lib = library[index];
            if (lib.getName().equals(targetName)) {
                System.out.println("Найдена: " + lib.getName() + " индекс " + index);
            }
        }
    }
}
