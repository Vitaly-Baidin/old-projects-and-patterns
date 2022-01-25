public abstract class Car {
    private String name;
    private String model;

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public abstract void move();
    public abstract void stop();

    public String toString(){
        return "============================================" + System.lineSeparator() +
                "car name: " + name + System.lineSeparator() +
                "car model: " + model + System.lineSeparator() +
                "============================================";
    }
}
