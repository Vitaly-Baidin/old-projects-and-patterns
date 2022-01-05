import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {
    private static double companyIncome;
    private String companyName;
    private List<Employee> employeesList = new ArrayList<>();

    public Company(String name, double income) {
        companyName = name;
        companyIncome = income;
    }

    public void hire(Employee employee) {
        employeesList.add(employee);
    }

    public void hireAll(List<Employee> employees) {
        employeesList.addAll(employees);
    }

    public void fire(Employee employee) {
        employeesList.remove(employee);
    }

    public static double getIncome() {
        return companyIncome;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        List<Employee> copyList = new ArrayList<>(employeesList);

        copyList.sort(Comparator.comparing(Employee::getMonthSalary, Comparator.reverseOrder()));

        for (int i = count; i < employeesList.size(); i++) {
            copyList.remove(count);
        }

        return copyList;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        List<Employee> copyList = new ArrayList<>(employeesList);

        copyList.sort(Comparator.comparing(Employee::getMonthSalary));

        for (int i = count; i < employeesList.size(); i++) {
            copyList.remove(count);
        }

        return copyList;
    }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

}