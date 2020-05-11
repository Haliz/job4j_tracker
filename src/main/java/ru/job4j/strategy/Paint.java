package ru.job4j.strategy;

public class Paint {
    public void draw(Shape shape) {
        System.out.print(shape.draw());
    }

    public static void main(String[] args) {
        Square square = new Square();
        Triangle triangle = new Triangle();
        Paint paint = new Paint();
        paint.draw(square);
        paint.draw(triangle);
    }
}