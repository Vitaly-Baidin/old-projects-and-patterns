package ru.skillbox;

public class Screen {
    private final double diagonal;
    private final ScreenType screenType;
    private final double weight;

    public Screen(double diagonal, ScreenType screenType, double weight) {
        this.diagonal = diagonal;
        this.screenType = screenType;
        this.weight = weight;
    }

    public Screen setDiagonal(double diagonal) {
        return new Screen(diagonal, screenType, weight);
    }

    public Screen setScreenType(ScreenType screenType) {
        return new Screen(diagonal, screenType, weight);
    }

    public Screen setWeight(double weight) {
        return new Screen(diagonal, screenType, weight);
    }

    public double getDiagonal() {
        return diagonal;
    }

    public ScreenType getScreenType() {
        return screenType;
    }

    public double getWeight() {
        return weight;
    }
}
