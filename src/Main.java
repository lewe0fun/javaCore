public class Main {
    public static void main(String[] args) {
        Employee[] employees = {new Manager("Yuriy", "Urchin", "ceo", 500000, 46),
                new Employee("Ivan", "Ivanov", "администратор", 10000.3, 25),
                new Employee("Petr", "Petrov", "уборщик", 7500.5, 46)};
        for (Employee e : employees)
            System.out.println(e);

        System.out.println();
        Manager.salaryUp(employees, 45, 99);

        for (Employee e : employees)
            System.out.println(e);

        System.out.println();
        Employee.comparePrint(
                new Employee("Ivan", "Ivanov", "администратор", 10000.3, 25),
                new Employee("Petr", "Petrov", "уборщик", 7500.5, 46));
    }
}