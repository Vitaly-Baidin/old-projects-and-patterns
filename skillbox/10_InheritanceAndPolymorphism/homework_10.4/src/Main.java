public class Main {
    public static void main(String[] args) {
        Company company = new Company("DoDo", 2_000_000);
        int random;

        for (int i = 0; i < 180; i++) {
            company.hire(new Operator(company));
            if (i < 80) {
                company.hire(new Manager(company));
            }
            if (i < 10) {
                company.hire(new TopManager(company));
            }
        }
        System.out.println("\nТоп 15 высоких зарплат в компании");
        for (Employee elem : company.getTopSalaryStaff(15)) {
            System.out.printf("%.2f",elem.getMonthSalary());
            System.out.println();
        }
        System.out.println("\nТоп 15 низких зарплат в компании");
        for (Employee elem : company.getLowestSalaryStaff(15)) {
            System.out.printf("%.2f",elem.getMonthSalary());
            System.out.println();
        }
        System.out.println("\nУволены 50% сотрудников");
        for (int i = 0; i < company.getEmployeesList().size() / 2; i++) {
            random = (int) (Math.random() * company.getEmployeesList().size());
            company.getEmployeesList().remove(random);
        }
        System.out.println("\nТоп 15 высоких зарплат в компании");
        for (Employee elem : company.getTopSalaryStaff(15)) {
            System.out.printf("%.2f",elem.getMonthSalary());
            System.out.println();
        }
        System.out.println("\nТоп 15 низких зарплат в компании");
        for (Employee elem : company.getLowestSalaryStaff(15)) {
            System.out.printf("%.2f",elem.getMonthSalary());
            System.out.println();
        }


    }

}
