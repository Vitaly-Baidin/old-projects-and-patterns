
public class Loader
{
    public static void main(String[] args)
    {
        Cat Vaska = new Cat(2000.0, "Вася");
        Cat Murka = new Cat(Vaska.getWeight(),Vaska.getCatName());

        Murka.setCatName("Мурка");

        System.out.println(Vaska.getCatName() + " " + Vaska.getWeight());
        System.out.println(Murka.getCatName() + " " + Murka.getWeight());

        Cat cat8 = new Cat();
        cat8.feed(100.0);
        cat8.feed(50.0);
        cat8.pee();
        cat8.pee();
        System.out.println(cat8.getFeed());

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        Cat cat5 = new Cat();
        Cat cat6 = new Cat();
        Cat cat7 = new Cat();

        System.out.println(cat1.getWeight());
        System.out.println(cat2.getWeight());
        System.out.println(cat3.getWeight());
        System.out.println(cat4.getWeight());
        System.out.println(cat5.getWeight());
        System.out.println(cat6.getWeight());
        System.out.println(cat7.getWeight());

        cat1.feed(200.0);
        cat2.feed(400.0);

        System.out.println("\n" + cat1.getWeight());
        System.out.println(cat2.getWeight() + "\n");

        while (cat3.getWeight() <= 9000)
        {
            cat3.feed(cat3.getWeight() * 0.2);
        }

        System.out.println(cat3.getStatus());

        while (cat4.getWeight() >= 1000)
        {
            cat4.meow();
        }
        getKitten();
        System.out.println(Cat.getCount());
        cat3.feed(100.0);
    }

    private static Cat getKitten()
    {
        return new Cat(1100.0);
    }
}