import java.util.Objects;

public class Employee {
    private final int id;
    private final String name;
    private final String surname;
    private final String fathername;
    private int salary;
    private int department;

    public Employee(int id, String surname, String name, String fathername, int salary, int department) {
        this.name = name;
        this.salary = salary;
        this.surname = surname;
        this.fathername = fathername;
        this.id = id;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && department == employee.department && Objects.equals(name, employee.name)
                && Objects.equals(surname, employee.surname) && Objects.equals(fathername, employee.fathername);
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

    public void setDepartment(int department) {
        this.department = department;
    }

    public void indexing(int ind) {
        double tmp = (this.salary / 100) * ind;

        this.salary += (int) tmp;
    }

}
