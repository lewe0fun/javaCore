import java.util.Comparator;

public class Employee implements Comparable<Employee> {
    private String firstName;
    private String LastName;
    private String position;
    private double salary;
    private int phone;
    private int age;

    public Employee(String firstName, String secondName, String position, double salary, int age) {
        this.firstName = firstName;
        this.LastName = secondName;
        this.position = position;
        this.salary = salary;
        this.age = age;
    }

    public Employee(String firstName, String secondName) {
        this.firstName = firstName;
        this.LastName = secondName;
    }

public void shortPrint(){
    System.out.print(this.getPosition()+" "+this.getFirstName()+" "+this.getLastName());
}

    public static void comparePrint(Employee e1, Employee e2) {
        int result = e1.compareTo(e2);
        e1.shortPrint();
        switch (result) {
            case (0) -> System.out.print(" равен ");
            case (-1) -> System.out.print(" меньше ");
            case (1) -> System.out.print(" больше ");
        }
        e2.shortPrint();
    }

    @Override
    public String toString() {
        return "Сотрудник - " +
                "Имя: " + firstName + '\'' +
                ", Фамилия: " + LastName + '\'' +
                ", Возраст: " + age + '\'' +
                ", Должность: " + position + '\'' +
                ", Зарплата: " + salary +
                ", Телефон: " + phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Employee employee) {
        return Comparator.comparing(Employee::getSalary)
                .thenComparingInt(Employee::getAge)
                .compare(this, employee);
    }
}
