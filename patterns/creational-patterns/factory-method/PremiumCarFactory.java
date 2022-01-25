public class PremiumCarFactory extends CarFactory{
    @Override
    public PremiumCar createCar() {
        return new PremiumCar();
    }
}
