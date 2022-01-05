public class Account{

    private long money;
    private String accNumber;
    private volatile boolean isBlocked;

    public Account(long money, String accNumber){
        this.money = money < 0 ? 0 : money;
        this.accNumber = accNumber;
        this.isBlocked = false;
    }

    public long getMoney() {
        return money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public void putMoney(long money){
        if (money <= 0) {
            System.out.println("Неккоректная сумма внесения");
            return;
        }
        this.money += money;
    }

    public void withdrawMoney(long money) {
        if (money > this.money) {
            System.out.println("Неккоректная сумма списания");
            return;
        }
        this.money -= money;
    }
}