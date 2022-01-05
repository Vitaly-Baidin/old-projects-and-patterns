public class Manager implements Employee{

    private static final double SALARY = 70_000;
    private Company company;
    private double incomeCompany;

    public Manager(Company company) {
        this.company = company;
        this.incomeCompany = (Math.random() * 140000) + 115000;
    }

    @Override
    public double getMonthSalary() {
        return SALARY + (incomeCompany * 0.05);
    }
}
