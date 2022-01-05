import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Bank {

    private HashMap<String, Account> accounts;
    private final Random random = new Random();

    public Bank(){
        accounts = new HashMap<>();
        for (int i = 100000; i < 1000000; i++){
            accounts.put("" + i, new Account(random.nextInt(1000000), "" + i));
        }
    }



    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public synchronized void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        if (amount > 50_000){
            System.out.println("Подозрительная транзакция, отправляем на проверку");
            boolean security = isFraud(fromAccountNum, toAccountNum, amount);
            accounts.get(fromAccountNum).setBlocked(security);
            accounts.get(toAccountNum).setBlocked(security);
            if (security)
                System.out.println("Аккаунты заблокированы:" +
                        "\n" + fromAccountNum + " и " + toAccountNum);
        }
        if (!accounts.get(fromAccountNum).isBlocked() && !accounts.get(toAccountNum).isBlocked() && getBalance(fromAccountNum) >= amount){
            System.out.println("ТРАНЗАКЦИЯ: " + accounts.get(fromAccountNum).getMoney() + "->" + accounts.get(toAccountNum).getMoney());
            //synchronized ();
            accounts.get(fromAccountNum).withdrawMoney(amount);
            accounts.get(toAccountNum).putMoney(amount);
        }
    }

    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long allMoney(){
        AtomicLong sum = new AtomicLong();
        accounts.forEach((k, v) -> sum.addAndGet(v.getMoney()));

        return sum.get();
    }
}
