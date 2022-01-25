public class Employee implements Cloneable {

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

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    protected Employee clone() throws CloneNotSupportedException {
        return new Employee(employeeId, firstName, lastName, salary, projectName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}