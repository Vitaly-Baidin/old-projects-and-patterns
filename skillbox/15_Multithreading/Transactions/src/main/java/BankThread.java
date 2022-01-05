import java.util.Random;

public class BankThread implements Runnable{
    Bank bank;
    Random random;

    public BankThread(Bank bank){
        this.bank = bank;
        random = new Random();
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i++){
            long amount = random.nextInt(50000);
            if (i % 20 == 0) amount += 50000;

            String fromAccount = random.nextInt(90000) + 100000 + "";
            String toAccount = random.nextInt(90000) + 100000 + "";
            try {
                bank.transfer(fromAccount, toAccount, amount);
            } catch (Exception e){
                e.printStackTrace();
            }

        }
        System.out.println("Сумма всех денежных средств в банке " + bank.allMoney());
    }
}
