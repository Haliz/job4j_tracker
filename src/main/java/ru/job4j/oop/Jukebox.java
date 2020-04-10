package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1){
            System.out.println("Пусть бегут неуклюже");
        }
        else if (position == 2) {
            System.out.println("Спокойной ночи");
        }
        else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox sound1 = new Jukebox();
        sound1.music (1);
        Jukebox sound2 = new Jukebox();
        sound2.music (2);
        Jukebox sound3 = new Jukebox();
        sound3.music (3);

    }
}
