public class EmployeeBuilder {

    private int employeeId;
    private String firstName;
    private String lastName;
    private int salary;
    private String projectName;

    public EmployeeBuilder() {
        super();
    }

    public EmployeeBuilder setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public EmployeeBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeBuilder setSalary(int salary) {
        this.salary = salary;
        return this;
    }

    public EmployeeBuilder setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public Employee getEmployee() {
        if (validateEmployee()) {
            return new Employee(employeeId, firstName, lastName, salary, projectName);
        } else {
            throw new IllegalArgumentException("Employee need lastname and firstname and employeeID");
        }
    }

    private boolean validateEmployee() {
        return (employeeId > 0 && firstName != null && lastName != null);
    }
}
