public class TopManager implements Employee{

    private Company company;
    public final double SALARY;

    public TopManager(Company company) {
        this.company = company;
        SALARY = (Math.random() * 200000) + 170000;
    }

    @Override
    public double getMonthSalary() {
        return SALARY + Company.getIncome();
    }
}
