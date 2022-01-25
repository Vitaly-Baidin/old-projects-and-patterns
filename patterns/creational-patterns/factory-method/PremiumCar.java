public class PremiumCar extends Car {
    public PremiumCar() {
    }

    @Override
    public void move() {
        System.out.println("Премиальная машина поехала");
    }

    @Override
    public void stop() {
        System.out.println("Премиальная машина остановилась");
    }
}
