public class Main {
    public static void main(String[] args) {
        ClientFactory clientFactory = new ClientFactory();
        Person person1 = clientFactory.createPerson();
        Person person2 = clientFactory.createPerson();

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee employee1 = employeeFactory.createPerson();
        Employee employee2 = employeeFactory.createPerson();
    }
}
