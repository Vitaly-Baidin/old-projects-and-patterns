public class Main {
    public static void main(String[] args) {
        PremiumCarFactory premiumCarFactory = new PremiumCarFactory();
        PremiumCar premiumCar = premiumCarFactory.createCar();
        premiumCar.setName("Lexsota");
        premiumCar.setModel("PREMIUM");
        System.out.println(premiumCar);

        BasicCarFactory basicCarFactory = new BasicCarFactory();
        BasicCar basicCar = basicCarFactory.createCar();
        basicCar.setName("RAP");
        basicCar.setModel("BASIC");
        System.out.println(basicCar);
    }
}
