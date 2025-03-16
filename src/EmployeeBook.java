import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeBook {
    private ArrayList<Employee> employees = new ArrayList();
    private int count = 0;

    public int fail(int a, int b) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от " + a + " до " + b + ": ");
        while (true) {
            try {
                int n = scanner.nextInt();
                if (n >= a && n <= b)
                    return n;
                else
                    System.out.println("Введите корректное значение!");
            } catch (InputMismatchException e) {
                System.out.println("Введите корректное значение!");
            }
        }
    }

    public String fail(String tmp) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (!tmp.isEmpty()) {
                return tmp;
            } else
                System.out.println("Введите хоть что-то");
            tmp = scanner.nextLine();
        }
    }

    public void printEmployee() {
        System.out.println("\nСписов всех сотрудников");
        for (int i = 0; i < employees.size(); ++i) {
            System.out.println(employees.get(i));
        }
    }

    public void printEmployee(int department) {
        System.out.println("\nСписов сотрудников отдела " + department);
        for (int i = 0; i < employees.size(); ++i) {
            if (employees.get(i).getDepartment() == department)
                System.out.println(employees.get(i));
        }
    }

    public void sumSalary() {
        int sum = 0;
        for (int i = 0; i < employees.size(); ++i) {
            sum += employees.get(i).getSalary();
        }
        System.out.println("Сумма затрат на ЗП на всех сотрудников: " + sum + " $");
    }

    public void sumSalary(int department) {
        int sum = 0;
        for (int i = 0; i < employees.size(); ++i) {
            if (employees.get(i).getDepartment() == department)
                sum += employees.get(i).getSalary();
        }
        if (sum != 0)
            System.out.println("Сумма затрат на ЗП на сотрудников из " + department + " отдела: " + sum + " $");
        else
            System.out.println("В базе не хватает сотрудников");
    }

    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        name = fail(name);
        System.out.print("Введите фамилию: ");
        String surname = scanner.nextLine();
        surname = fail(surname);
        System.out.print("Введите отчество: ");
        String fathername = scanner.nextLine();
        fathername = fail(fathername);
        int id = count++;
        System.out.print("Введите ЗП: ");
        int salary = fail(1, 200000);
        System.out.println("Введите отдел");
        int department = fail(1, 5);
        Employee employee = new Employee(id, surname, name, fathername, salary, department);

        this.employees.add(employee);
    }

    public void remove() {
        System.out.println("Введите id сотрудника: ");
        int id = fail(0, 200);
        boolean check = false;
        for (int i = 0; i < employees.size(); ++i) {
            if (this.employees.get(i).getId() == id) {
                System.out.println("Сотрудник: " + employees.get(i).getFullName() + " был удалён из базы данных.");
                employees.remove(i);
                check = true;
            }
        }
        if (!check)
            System.out.println("В базе нет сотрудника с таким ID");
    }

    public int getSize() {
        return employees.size();
    }

    public void middleSalary() {
        int sum = 0;
        for (int i = 0; i < employees.size(); ++i) {
            sum += employees.get(i).getSalary();
        }
        if (sum != 0)
            System.out.println("Среднее значение ЗП среди всех сотрудников: " + sum / employees.size() + " $");
        else
            System.out.println("В базе не хватает сотрудников");

    }

    public void middleSalary(int department) {
        int sum = 0;
        for (int i = 0; i < employees.size(); ++i) {
            if (employees.get(i).getDepartment() == department)
                sum += employees.get(i).getSalary();
        }
        if (sum != 0)
            System.out.println("Среднее значение ЗП среди сотрудников " + department + " отдела: " +
                    sum / employees.size() + " $");
        else
            System.out.println("В базе не хватает сотрудников");

    }

    public void minSalary() {
        int tmp = 0;
        for (int i = 1; i < employees.size(); i++) {
            if (employees.get(i).getSalary() < employees.get(tmp).getSalary())
                tmp = i;
        }
        System.out.println("Самая маленькая ЗП среди всех сотрудников у " + employees.get(tmp).getFullName());

    }

    public void minSalary(int department) {
        int tmp = 0;
        ArrayList<Employee> employees1 = new ArrayList<Employee>();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getDepartment() == department)
                employees1.add(employees.get(i));

        }
        if (!employees1.isEmpty()) {
            for (int i = 1; i < employees1.size(); i++) {
                if (employees1.get(i).getSalary() < employees1.get(tmp).getSalary())
                    tmp = i;
            }
            System.out.println("Самая маленькая ЗП среди сотрудников " + department + " отдела у " +
                    employees.get(tmp).getFullName());
        } else
            System.out.println("В базе не хватает сотрудников");

    }

    public void maxSalary() {
        int tmp = 0;
        for (int i = 1; i < employees.size(); i++) {
            if (employees.get(i).getSalary() > employees.get(tmp).getSalary())
                tmp = i;
        }
        System.out.println("Самая большая ЗП среди всех сотрудников у " + employees.get(tmp).getFullName());

    }

    public void maxSalary(int department) {
        int tmp = 0;
        ArrayList<Employee> employees1 = new ArrayList<Employee>();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getDepartment() == department)
                employees1.add(employees.get(i));

        }
        if (!employees1.isEmpty()) {
            for (int i = 1; i < employees1.size(); i++) {
                if (employees1.get(i).getSalary() > employees1.get(tmp).getSalary())
                    tmp = i;
            }
            System.out.println("Самая большая ЗП среди сотрудников " + department + " отдела у " +
                    employees.get(tmp).getFullName());
        } else
            System.out.println("В базе не хватает сотрудников");

    }

    public void getEmployee() {
        System.out.println("Введите id сотрудника: ");
        int id = fail(0, 200);
        boolean check = false;
        for (int i = 0; i < employees.size(); i++) {
            if (id == employees.get(i).getId()) {
                System.out.println(employees.get(i));
                check = true;
            }
        }
        if (!check)
            System.out.println("В базе нет сотрудника с таким ID");
    }

    public void indexing(int ind) {
        for (int i = 0; i < employees.size(); i++) {
            int tmp = employees.get(i).getSalary();
            employees.get(i).indexing(ind);
            System.out.println("Индексация для " + employees.get(i).getFullName() +
                    " произведена успешно, и теперь ЗП составляет: " + employees.get(i).getSalary());
            System.out.println("Было: " + tmp);
        }
    }

    public void indexing(int ind, int department) {
        boolean check = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getDepartment() == department) {
                int tmp = employees.get(i).getSalary();
                employees.get(i).indexing(ind);
                System.out.println("Индексация для " + employees.get(i).getFullName() +
                        " произведена успешно, и теперь ЗП составляет: " + employees.get(i).getSalary());
                System.out.println("Было: " + tmp);
                check = true;
            }

        }
        if (!check)
            System.out.println("В базе не хватает сотрудников");
    }

    public void searchPlus() {
        boolean check = false;
        System.out.print("Введите уровень ЗП для поиска:");
        int tmp = fail(1, 200000);
        System.out.println("Список сотрудников с ЗП больше или равной указанной");
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getSalary() >= tmp) {
                System.out.println(employees.get(i));
                check = true;

            }
        }
        if (!check)
            System.out.println("В базе отсутствуют сотрудники с таким уровнем ЗП");

    }

    public void searchMinus() {
        boolean check = false;
        System.out.print("Введите уровень ЗП для поиска:");
        int tmp = fail(1, 200000);
        System.out.println("Список сотрудников с ЗП меньше указанной");
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getSalary() < tmp) {
                System.out.println(employees.get(i));
                check = true;

            }
        }
        if (!check)
            System.out.println("В базе отсутствуют сотрудники с таким уровнем ЗП");

    }

    public void editSalary() {
        System.out.println("Введите id сотрудника: ");
        int id = fail(0, 200);
        int tmp = 0;
        boolean check = false;
        for (int i = 0; i < employees.size(); i++) {
            if (id == employees.get(i).getId()) {
                System.out.println("Сотрудник с номером id " + id + " это: " + employees.get(i).getFullName() +
                        " ЗП: " + employees.get(i).getSalary());
                tmp = i;
                check = true;
            }
        }
        if (!check)
            System.out.println("В базе нет сотрудника с таким ID");
        else {
            System.out.print("Введите ЗП: ");
            int salary = fail(1, 200000);
            employees.get(tmp).setSalary(salary);
            System.out.println("Готово!");
        }
    }

    public void editDepartment() {
        System.out.println("Введите id сотрудника: ");
        int id = fail(0, 200);
        int tmp = 0;
        boolean check = false;
        for (int i = 0; i < employees.size(); i++) {
            if (id == employees.get(i).getId()) {
                System.out.println("Сотрудник с номером id " + id + " это: " + employees.get(i).getFullName() +
                        ", отдел: " + employees.get(i).getDepartment());
                tmp = i;
                check = true;
            }
        }
        if (!check)
            System.out.println("В базе нет сотрудника с таким ID");
        else {
            System.out.print("Введите отдел: ");
            int department = fail(1, 5);
            employees.get(tmp).setDepartment(department);
            System.out.println("Готово!");
        }
    }

    public void getHashCode() {
        System.out.println("Введите id сотрудника: ");
        int id = fail(0, 200);
        boolean check = false;
        for (int i = 0; i < employees.size(); i++) {
            if (id == employees.get(i).getId()) {
                System.out.println("Сотрудник с номером id " + id + " это: " + employees.get(i).getFullName() +
                        " HashCode: " + employees.get(i).hashCode());
                check = true;
            }
        }
        if (!check)
            System.out.println("В базе нет сотрудника с таким ID");
    }

    public void equalsEmployee() {
        System.out.println("Введите id первого сотрудника: ");
        int id1 = fail(0, 200);
        int tmp1 = 0;
        boolean check = false;
        for (int i = 0; i < employees.size(); i++) {
            if (id1 == employees.get(i).getId()) {
                System.out.println("Сотрудник с номером id " + id1 + " это: " + employees.get(i).getFullName() +
                        ", отдел: " + employees.get(i).getDepartment());
                tmp1 = i;
                check = true;
            }
        }
        if (!check) {
            System.out.println("В базе нет сотрудника с таким ID");
            return;
        }
        System.out.println("Введите id второго сотрудника: ");
        int id2 = fail(0, 200);
        int tmp2 = 0;
        check = false;
        for (int i = 0; i < employees.size(); i++) {
            if (id1 == employees.get(i).getId()) {
                System.out.println("Сотрудник с номером id " + id2 + " это: " + employees.get(i).getFullName() +
                        ", отдел: " + employees.get(i).getDepartment());
                tmp2 = i;
                check = true;
            }
        }
        if (!check) {
            System.out.println("В базе нет сотрудника с таким ID");
            return;
        }
        if (employees.get(tmp1).equals(employees.get(tmp2)))
            System.out.println("Люди под этими ID равны");
        else
            System.out.println("Люди под этими ID не равны");
    }
}
