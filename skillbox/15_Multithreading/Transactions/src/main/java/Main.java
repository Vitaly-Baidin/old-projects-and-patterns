public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        System.out.println("Сумма всех денежных средств в банке " + bank.allMoney());

        for (int i = 0; i < 5; i++){
            new Thread(new BankThread(bank)).start();
        }
    }
}
