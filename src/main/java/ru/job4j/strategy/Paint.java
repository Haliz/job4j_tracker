package ru.job4j.strategy;

public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw() + System.lineSeparator());
    }

    public static void main(String[] args) {
        Square square = new Square();
        Triangle triangle = new Triangle();
        Paint paint = new Paint();
        paint.draw(square);
        paint.draw(triangle);
    }
}