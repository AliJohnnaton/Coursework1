import java.util.Objects;

public class Employee {
    private static int counter = 0;
    private final int id;
    private final String name;
    private final String surname;
    private final String fathername;
    private int salary;
    private final int department;

    public Employee(String surname, String name, String fathername, int salary, int department) {
        this.name = name;
        this.salary = salary;
        this.surname = surname;
        this.fathername = fathername;
        this.id = counter++;
        this.department = department;
    }

    public static int getMaxID() {
        return counter - 1;
    }

    public String getFullName() {
        return this.surname + " " + this.name + " " + this.fathername;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return this.id;
    }

    public int getDepartment() {
        return this.department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return salary == employee.salary && department == employee.department && Objects.equals(name, employee.name)
                && Objects.equals(surname, employee.surname) && Objects.equals(fathername, employee.fathername) &&
                Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, fathername, salary, department);
    }

    @Override
    public String toString() {
        return "ID=" + id +
                ", Имя='" + name + '\'' +
                ", Фамилия='" + surname + '\'' +
                ", Отчество='" + fathername + '\'' +
                ", ЗП=" + salary +
                ", Отдел=" + department;
    }

}
