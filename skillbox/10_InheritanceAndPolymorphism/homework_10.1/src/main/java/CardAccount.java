public class CardAccount extends BankAccount {
    public boolean take(double amountToTake) {
        if (super.take((amountToTake * 0.01) + amountToTake)) {
            return true;
        }
        return false;
    }
}
