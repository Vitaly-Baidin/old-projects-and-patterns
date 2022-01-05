import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Movements {
    private ArrayList<BankAccount> movementList;


    public Movements(String movementListFile) {
        movementList = loadMovementListFromFile(movementListFile);
    }

    private ArrayList<BankAccount> loadMovementListFromFile(String movementListFile) {

        ArrayList<BankAccount> movementList = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(movementListFile));
            lines.remove(0);
            for (String line : lines) {
                List<String> lines1 = new ArrayList<>();
                String lineMovementList = line.replaceAll("(\\\")(\\d+)(,)(\\d+)(\\\")", "$2\\.$4")
                        .replaceAll("[(-)]", "");
                lines1.add(lineMovementList);
                for (String line1 : lines1) {
                    String[] fragments = line1.split(",");
                    if (fragments.length != 8) {
                        System.out.println("Wrong line: " + line);
                        continue;
                    }
                    String companyName = fragments[5]
                            .replaceAll("\\s\\d+\\.\\d+\\.\\d+\\s(.+)", "")
                            .replaceAll("\\d+\\++\\d+", "")
                            .replaceAll("^.+(\\\\|\\/)", "")
                            .replaceAll("\\>\\w+", "")
                            .trim();
                    BigDecimal income = new BigDecimal(fragments[6]);
                    BigDecimal expense = new BigDecimal(fragments[7]);

                    movementList.add(new BankAccount(
                            companyName,
                            income,
                            expense
                    ));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return movementList;
    }

    public double getExpenseSum() {
        List<BigDecimal> listExpense = new ArrayList<>();
        for (BankAccount bankAccount : movementList) {
            listExpense.add(bankAccount.getMoneySpending());
        }
        BigDecimal amountOfExpenses = new BigDecimal(0.0);
        for (int i = 0; i < listExpense.size(); i++) {
            amountOfExpenses = amountOfExpenses.add(new BigDecimal(String.valueOf(listExpense.get(i))));
        }
        return amountOfExpenses.doubleValue();
    }

    public double getIncomeSum() {
        List<BigDecimal> listIncome = new ArrayList<>();
        for (BankAccount bankAccount : movementList) {
            listIncome.add(bankAccount.getMoneyArrival());
        }
        BigDecimal amountOfIncome = new BigDecimal(0.0);
        for (int i = 0; i < listIncome.size(); i++) {
            amountOfIncome = amountOfIncome.add(new BigDecimal(String.valueOf(listIncome.get(i))));
        }
        return amountOfIncome.doubleValue();
    }

    public ArrayList<BankAccount> getOperations() {
        return movementList;
    }
}
