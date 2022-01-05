
public class Cat
{
    public static final int COUNT_EYES = 2;
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;

    public static int count;

    private double originWeight;
    private double weight;
    private double countFeed;
    private String catName;
    private CatColorType catColor;
    private boolean isAlive = true;


    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count = count + 1;

    }

    public Cat(double weight)
    {
        this.weight = weight;
        originWeight = weight;
        count = count + 1;
    }

    public Cat(double weight, String name)
    {
        this.weight = weight;
        this.catName = name;
        originWeight = weight;
        count = count + 1;
    }

    public void meow()
    {
        if (isAlive) {
            weight = weight - 1;
            System.out.println("Meow");
            if (!isWeightNormal())
            {
                isAlive = false;
                count--;
            }
        }
        else
        {
            System.out.println("Котик не может мяукать :(");
        }
    }

    public void feed(Double amount)
    {
        if (isAlive) {
            weight = weight + amount;
            countFeed += amount;
            if (!isWeightNormal())
            {
                isAlive = false;
                count--;
            }
        }
        else
        {
            System.out.println("Котик не может кушать :(");
        }
    }

    public void drink(Double amount)
    {
        if (isAlive) {
            weight = weight + amount;
            if (!isWeightNormal())
            {
                isAlive = false;
                count--;
            }
        }
        else
        {
            System.out.println("Котик не может пить :(");
        }
    }
    public void pee()
    {
        if (isAlive) {
            weight = weight - 1;
            System.out.println("Pee");
            if (!isWeightNormal())
            {
                isAlive = false;
                count--;
            }
        }
        else
        {
            System.out.println("Котик не может сходить в туалет :(");
        }
    }

    public boolean isWeightNormal()
    {
        return (getWeight()> MIN_WEIGHT && getWeight() <MAX_WEIGHT);
    }
    public void setColorCat(CatColorType type)
    {
        this.catColor = type;
    }

    public void setCatName(String catName)
    {
        this.catName = catName;
    }

    public String getCatName()
    {
        return catName;
    }

    public CatColorType getCatColor()
    {
        return catColor;
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
    public Double getFeed()
    {
        return countFeed;
    }

    public static int getCount()
    {
        return count;
    }
}