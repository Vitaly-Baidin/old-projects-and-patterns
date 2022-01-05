public class BankAccount {
  private double currentAmount;

  public double getAmount() {
    return currentAmount;
  }

  public void put(double amountToPut) {
    if (amountToPut >= 0) {
      currentAmount += amountToPut;
    }
  }

  public boolean take(double amountToTake) {
    if (amountToTake >= 0 && amountToTake <= currentAmount) {
      currentAmount -= amountToTake;
      return true;
    }
    return false;
  }

  public boolean send(BankAccount receiver, double amount) {
    if (take(amount)) {
      receiver.put(amount);
      return true;
    }
    return false;
  }
}
