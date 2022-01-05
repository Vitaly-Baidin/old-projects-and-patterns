package ru.skillbox;

public class Dimensions {
    private final double height;
    private final double width;
    private final double depth;

    public Dimensions(double height, double width, double depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public double getSquare() {
        return height * width * depth;
    }

    public Dimensions setHeight(double height) {
        return new Dimensions(height, width, depth);
    }

    public Dimensions setWidth(double width) {
        return new Dimensions(height, width, depth);
    }

    public Dimensions setDepth(double depth) {
        return new Dimensions(height, width, depth);
    }
}
