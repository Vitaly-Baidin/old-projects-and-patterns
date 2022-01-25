public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee employee1 = new Employee(1, "Ivan", "Ivanov", 100, "SuperX");
        Employee employee2 = employee1.clone();
        employee1.setFirstName("Maksim");
        System.out.println(employee1);
        System.out.println(employee2);
    }
}
