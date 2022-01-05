package ru.skillbox;

public class Keyboard {
    private final KeyboardType keyboardType;
    private final boolean isBacklight;
    private final double weight;

    public Keyboard(KeyboardType keyboardType, boolean isBacklight, double weight) {
        this.keyboardType = keyboardType;
        this.isBacklight = isBacklight;
        this.weight = weight;
    }

    public Keyboard setKeyboardType(KeyboardType keyboardType) {
        return new Keyboard(keyboardType, isBacklight, weight);
    }

    public Keyboard setIsBackLight(boolean isBacklight) {
        return new Keyboard(keyboardType, isBacklight, weight);
    }

    public Keyboard setWeight(double weight) {
        return new Keyboard(keyboardType, isBacklight, weight);
    }

    public KeyboardType getKeyboardType() {
        return keyboardType;
    }

    public boolean getIsBacklight() {
        return isBacklight;
    }

    public double getWeight() {
        return weight;
    }
}
