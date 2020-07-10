package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matches = 11;
        int index = 0;
        int takeMatches;
        boolean player;
        do {
            player = index % 2 == 0;
            System.out.println("Количество спичек на столе - " + matches);
            do {
                if (player) {
                    System.out.println("Игрок 1 возьмите от 1 до 3 спичек.\nНо не более общего количества спичек.\nСколько спичек Вы взяли?");
                } else {
                    System.out.println("Игрок 2 возьмите от 1 до 3 спичек.\nНо не более общего количества спичек.\nСколько спичек Вы взяли?");
                }
                int select = Integer.valueOf(input.nextLine());
                takeMatches = select;
                } while (takeMatches < 1 || takeMatches > 3 || takeMatches > matches);
                matches = matches - takeMatches;
                index++;
        } while (matches > 0);
        String winner = player ? "Игрок 1" :  "Игрок 2";
        System.out.println("Игра окончена!");
        System.out.println("Победил " + winner);
    }
}
