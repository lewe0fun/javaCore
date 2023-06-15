public class Manager extends Employee{

    public Manager(String firstName, String secondName, String position, double salary, int age) {
        super(firstName, secondName, position, salary, age);
    }

    public static void salaryUp(Employee[] employees, int age, double salary) {
        for (Employee employee : employees)
            if (!(employee instanceof Manager) && employee.getAge() > age)
                employee.setSalary(employee.getSalary() + salary);
    }
}
