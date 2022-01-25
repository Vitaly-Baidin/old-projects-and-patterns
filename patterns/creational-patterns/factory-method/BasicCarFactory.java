public class BasicCarFactory extends CarFactory{
    @Override
    public BasicCar createCar() {
        return new BasicCar();
    }
}
