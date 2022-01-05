import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private LocalDate lastPay = LocalDate.now();
    private LocalDate nextTake = lastPay.minusMonths(1);

    public void put(double amountToPut) {
        lastPay = LocalDate.now();
        nextTake = lastPay.plusMonths(1);
        super.put(amountToPut);
    }

    public boolean take(double amountToTake) {
        if (lastPay.isBefore(nextTake)) {
            super.take(amountToTake);
            return true;
        }
        return false;
    }
}
