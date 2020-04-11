package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        Ball ball = new Ball();

        hare.tryEat(ball);
        ball.getAway(hare);
        wolf.tryEat(ball);
        ball.getAway(wolf);
        fox.tryEat(ball);
    }
}
