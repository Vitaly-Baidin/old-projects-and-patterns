package ru.skillbox;

public class Cargo {
    private final double height;
    private final double width;
    private final double depth;

    private final Dimensions dimensions = new Dimensions(1.0, 1.0, 1.0);

    private final double weight;

    private final String addressDelivery;

    private final boolean canFlip;

    private final String regNumber;

    private final boolean glass;

    public Cargo(double height,double width,double depth,double weight,String addressDelivery,boolean canFlip,String regNumber,boolean glass) {
        this.height = height;
        this.width = width;
        this.depth = depth;

        dimensions.setHeight(height);
        dimensions.setWidth(width);
        dimensions.setDepth(depth);

        this.weight = weight;
        this.addressDelivery = addressDelivery;
        this.canFlip = canFlip;
        this.regNumber = regNumber;
        this.glass = glass;
    }

    public Cargo setaddressDelivery(String addressDelivery) {
        return new Cargo(height,width,depth,weight,addressDelivery,canFlip,regNumber,glass);
    }

    public Cargo setDimension(double height, double width, double depth){
        return new Cargo(height,width,depth,weight,addressDelivery,canFlip,regNumber,glass);
    }

    public Cargo setWeight(double weight) {
        return new Cargo(height,width,depth,weight,addressDelivery,canFlip,regNumber,glass);
    }
}
