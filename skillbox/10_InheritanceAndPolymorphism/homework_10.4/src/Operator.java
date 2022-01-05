public class Operator implements Employee{

    public static final double SALARY = 30_000;
    private Company company;

    public Operator(Company company) {
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        return SALARY;
    }
}
