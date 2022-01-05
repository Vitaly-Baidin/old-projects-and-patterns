import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private static String movementListFile = "data/movementList.csv";

    public static void main(String[] args) {

        DecimalFormat formatter = new DecimalFormat("0.00");
        Movements movements = new Movements(movementListFile);
        ArrayList<BankAccount> movementList = movements.getOperations();

        Double income = movements.getIncomeSum();
        Double expense = movements.getExpenseSum();

        System.out.println("Сумма расходов: " + formatter.format(expense) + " руб.");
        System.out.println("Сумма доходов: " + formatter.format(income) + " руб.");
        System.out.println("=================");

        System.out.println("Суммы расходов по организациям:");

        for (Map.Entry entry : getMapNameExpense(movementList).entrySet()) {
            System.out.println(entry.getKey() + " - " + formatter.format(entry.getValue()) + " руб.");
        }

    }

    private static HashMap<String, BigDecimal> getMapNameExpense(ArrayList<BankAccount> movementList) {

        HashMap<String, BigDecimal> mapNameExpense = new HashMap<>();
        mapNameExpense.putAll(movementList.stream()
                .collect(Collectors.toMap(BankAccount::getCompanyName, BankAccount::getMoneySpending,
                        (s1, s2) -> (s1.add(new BigDecimal(String.valueOf(s2)))))));
        return mapNameExpense;
    }

}
