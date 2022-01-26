package shape;

import color.Color;

public class Rectangle extends Shape {
    private int height;
    private int width;

    public Rectangle(int height, int width, Color color) {
        super(color);
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) System.out.print("*\t");
            System.out.println();
        }
        System.out.println("Нарисован квадрат");
        System.out.println("Нарисован прямоугольник");
    }

    @Override
    public double getSquare() {
        return width * height;
    }
}
