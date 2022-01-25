import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        employeeBuilder.setFirsName("Vitalik");
        employeeBuilder.setLastName("Ivanov");
        employeeBuilder.setBirthday(LocalDate.now());
        System.out.println(employeeBuilder.getEmployee());
    }
}
