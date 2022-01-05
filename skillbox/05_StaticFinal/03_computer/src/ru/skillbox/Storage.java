package ru.skillbox;

public class Storage {
    private final MemoryType memoryType;
    private final double memoryGig;
    private final double weight;

    public Storage(MemoryType memoryType, double memoryGig, double weight) {
        this.memoryType = memoryType;
        this.memoryGig = memoryGig;
        this.weight = weight;
    }

    public Storage setMemoryType(MemoryType memoryType) {
        return new Storage(memoryType, memoryGig, weight);
    }

    public Storage setMemoryGig(double memoryGig) {
        return new Storage(memoryType, memoryGig, weight);
    }

    public Storage setWeight(double weight) {
        return new Storage(memoryType, memoryGig, weight);
    }

    public MemoryType getMemoryType() {
        return memoryType;
    }

    public double getMemoryGig() {
        return memoryGig;
    }

    public double getWeight() {
        return weight;
    }
}
