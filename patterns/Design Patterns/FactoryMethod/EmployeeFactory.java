public class EmployeeFactory extends PersonFactory{
    public  Employee createPerson() {
        System.out.println("Новый сотрудник");
        return new Employee();
    }
}
