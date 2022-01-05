package ru.skillbox;

public class RAM {
    private final RamType type;
    private final double volume;
    private final double weight;

    public RAM(RamType type, double volume, double weight) {
        this.type = type;
        this.volume = volume;
        this.weight = weight;
    }

    public RAM setType(RamType type) {
        return new RAM(type, volume, weight);
    }

    public RAM setVolume(double volume) {
        return new RAM(type, volume, weight);
    }

    public RAM setWeight(double weight) {
        return new RAM(type, volume, weight);
    }

    public RamType getType() {
        return type;
    }

    public double getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }
}
