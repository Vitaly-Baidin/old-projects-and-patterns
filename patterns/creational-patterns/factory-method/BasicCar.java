public class BasicCar extends Car{
    @Override
    public void move() {
        System.out.println("Обычная машина поехала");
    }

    @Override
    public void stop() {
        System.out.println("Обычная машина остановилась");
    }
}
