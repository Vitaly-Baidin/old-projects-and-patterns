package shape;

import color.Color;

public class Square extends Shape {

    private int width;

    public Square(int width, Color color) {
        super(color);
        this.width = width;
    }

    @Override
    public void draw() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) System.out.print("*\t");
            System.out.println();
        }
        System.out.println("Нарисован квадрат");
    }

    @Override
    public double getSquare() {
        return width * width;
    }
}
