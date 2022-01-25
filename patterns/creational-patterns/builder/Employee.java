public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private int salary;
    private String projectName;

    public Employee(int employeeId, String firstName, String lastName, int salary, String projectName) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.projectName = projectName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public String getProjectName() {
        return projectName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}