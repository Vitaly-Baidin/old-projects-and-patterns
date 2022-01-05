public class Main {


    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount();

        acc1.put(100D);
        acc2.put(100D);

        System.out.println(acc1.send(acc2, 100D));

    }
}
