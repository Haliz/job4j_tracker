package ru.job4j.oop;

public class Jukebox {
    public void music(String lyrics) {
        System.out.println("I can sign a song : " + lyrics);
    }

    public static void main(String[] args) {
        Jukebox petya = new Jukebox();
        for (int i = 1; i <= 3; i++) {
            String song;
            if (i == 1){
                song = "Пусть бегут неуклюже";
            }
            else if (i == 2) {
                song = "Спокойной ночи";
            }
            else {
                song = "Песня не найдена";
            }
            petya.music(song);
            System.out.println();
        }
    }
}
