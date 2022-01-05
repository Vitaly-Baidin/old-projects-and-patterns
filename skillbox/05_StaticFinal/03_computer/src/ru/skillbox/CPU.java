package ru.skillbox;

public class CPU {
    private final double frequency;
    private final int coreCount;
    private final double performance;
    private final double weight;

    public CPU(double frequency, int coreCount, double performance, double weight) {
        this.frequency = frequency;
        this.coreCount = coreCount;
        this.performance = performance;
        this.weight = weight;
    }

    public CPU setFrequency(double frequency) {
        return new CPU(frequency, coreCount, performance, weight);
    }

    public CPU setCoreCount(int coreCount) {
        return new CPU(frequency, coreCount, performance, weight);
    }

    public CPU setPerformance(double performance) {
        return new CPU(frequency, coreCount, performance, weight);
    }

    public CPU setWeight(double weight) {
        return new CPU(frequency, coreCount, performance, weight);
    }


    public double getFrequency() {
        return frequency;
    }

    public int getCoreCount() {
        return coreCount;
    }

    public double getPerformance() {
        return performance;
    }

    public double getWeight() {
        return weight;
    }
}
