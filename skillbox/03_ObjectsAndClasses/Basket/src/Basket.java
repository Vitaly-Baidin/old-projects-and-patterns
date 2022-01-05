public class Basket {

    private static int count = 0;
    private static int countItems = 0;
    private static int allPrice = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static int getCountItems() {
        return countItems;
    }

    public static int getAllPrice() {
        return allPrice;
    }

    public static void increaseCount(int count){
        Basket.count++;
    }

    public static void increaseAllPrice(int price) {
        Basket.allPrice = Basket.allPrice + price;
    }

    public static void increaseCountItems(int count) {
        Basket.countItems = Basket.countItems + count;
    }

    public static double avgPriceBasket(){
        return Basket.allPrice / Basket.count;
    }

    public static double avgPrice() {
        return Basket.allPrice / Basket.countItems;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        add(name, price, count, 0);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. " + weight * count + " кг. " + " - " + price;
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + weight * count;
        increaseAllPrice(price * count);
        increaseCountItems(count);
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
