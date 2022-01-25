public class Main {
    public static void main(String[] args) {
        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        employeeBuilder.setEmployeeId(1);
        employeeBuilder.setFirstName("Ivan");
        employeeBuilder.setLastName("Ivanov");

        System.out.println(employeeBuilder.getEmployee());
    }
}
