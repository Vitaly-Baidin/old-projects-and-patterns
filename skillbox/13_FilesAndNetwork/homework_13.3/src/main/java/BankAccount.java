import java.math.BigDecimal;

public class BankAccount {

    private String companyName;
    private BigDecimal moneyArrival;
    private BigDecimal moneySpending;

    public BankAccount(String companyName, BigDecimal moneyArrival
            , BigDecimal moneySpending) {
        this.companyName = companyName;
        this.moneyArrival = moneyArrival;
        this.moneySpending = moneySpending;
    }

    public String getCompanyName() {
        return companyName;
    }

    public BigDecimal getMoneyArrival() {
        return moneyArrival;
    }

    public BigDecimal getMoneySpending() {
        return moneySpending;
    }
}