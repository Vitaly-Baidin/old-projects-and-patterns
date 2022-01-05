import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        Calendar calendar = new GregorianCalendar(year, 0 , 0);
        return staff.stream().filter(e -> e.getWorkStart().after(calendar.getTime())).max(Comparator.comparing(Employee::getSalary)).get();
    }
}