import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeBook {
    private final Employee[][] employees = new Employee[5][10];

    public int checkValidationInt(int a, int b) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от " + a + " до " + b + ": ");
        int n = -1;
        do {
            try {
                n = scanner.nextInt();
                if (n >= a && n <= b) {
                    return n;
                } else {
                    System.out.println("Введите корректное значение!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите корректное значение!");
            }
        } while (n < a || n > b);
        return 0;
    }

    public int checkValidationID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от " + 0 + " до " + Employee.getMaxID() + ": ");
        int n = -1;
        do {
            try {
                n = scanner.nextInt();
                if (n >= 0 && n <= Employee.getMaxID()) {
                    return n;
                } else {
                    System.out.println("Введите корректное значение!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите корректное значение!");
            }
        } while (n < 0 || n > Employee.getMaxID());
        return 0;
    }

    public String checkValidationString(String tmpString) {
        do {
            Scanner scanner = new Scanner(System.in);
            if (!tmpString.isEmpty()) {
                return tmpString;
            } else {
                System.out.println("Введите хоть что-то");
            }
            tmpString = scanner.nextLine();
        } while (tmpString.isEmpty());
        return null;
    }

    public int numberOfEmployees() {
        int count = 0;
        for (Employee[] department : employees) {
            for (Employee e : department) {
                if (e != null) {
                    count++;
                }
            }
        }
        return count;
    }

    public int numberOfEmployeesByDepartment(int department) {
        int count = 0;

        for (Employee e : employees[department - 1]) {
            if (e != null) {
                count++;
            }
        }

        return count;
    }

    public void printAllEmployees() {
        System.out.println("\nСписов всех сотрудников");
        for (Employee[] department : employees) {
            for (Employee e : department) {
                if (e != null) {
                    System.out.println(e);
                }
            }
        }
    }

    public void printEmployeesByDepartment(int department) {
        System.out.println("\nСписов сотрудников отдела " + department);
        for (Employee e : employees[department - 1]) {
            if (e != null) {
                System.out.println(e);
            }
        }
    }

    public int sumSalary() {
        int sum = 0;
        for (Employee[] department : employees) {
            for (Employee e : department) {
                if (e != null) {
                    sum += e.getSalary();
                }
            }
        }
        return sum;
    }

    public int sumSalaryByDepartment(int department) {
        int sum = 0;
        for (Employee e : employees[department - 1]) {
            if (e != null) {
                sum += e.getSalary();
            }
        }
        return sum;
    }

    public boolean addEmployee(Employee employee) {
        int department = employee.getDepartment() - 1;
        for (int i = 0; i < employees[department].length; i++) {
            if (employees[department][i] == null) {
                employees[department][i] = employee;
                return true;
            }
        }
        return false;
    }

    public void removeEmployee(int id) {
        for (Employee[] department : employees) {
            for (int i = 0; i < department.length; i++) {
                if (department[i] != null && department[i].getId() == id) {
                    department[i] = null;
                }
            }
        }
    }

    public int averageSalary() {
        return sumSalary() / numberOfEmployees();
    }

    public int averageSalaryByDepartment(int department) {
        return sumSalaryByDepartment(department) / numberOfEmployeesByDepartment(department);

    }

    public Employee minSalary() {
        Employee min = null;
        for (Employee[] department : employees) {
            for (Employee e : department) {
                if (e != null && (min == null || e.getSalary() < min.getSalary())) {
                    min = e;
                }
            }
        }
        return min;
    }

    public Employee minSalaryByDepartment(int department) {
        Employee min = null;
        for (Employee e : employees[department - 1]) {
            if (e != null && (min == null || e.getSalary() < min.getSalary())) {
                min = e;
            }
        }
        return min;
    }

    public Employee maxSalary() {
        Employee max = null;
        for (Employee[] department : employees) {
            for (Employee e : department) {
                if (e != null && (max == null || e.getSalary() > max.getSalary())) {
                    max = e;
                }
            }
        }
        return max;
    }

    public Employee maxSalaryByDepartment(int department) {
        Employee max = null;
        for (Employee e : employees[department - 1]) {
            if (e != null && (max == null || e.getSalary() > max.getSalary())) {
                max = e;
            }
        }

        return max;
    }

    public Employee getEmployee(int id) {
        for (Employee[] department : employees) {
            for (Employee e : department) {
                if (e != null) {
                    if (id == e.getId()) {
                        return e;
                    }
                }
            }
        }
        return null;
    }

    public void indexSalaries(double percent) {
        for (Employee[] department : employees) {
            for (Employee e : department) {
                if (e != null) {
                    double tmp = e.getSalary();
                    e.setSalary((int) (tmp * ((percent / 100) + 1)));
                    System.out.println("Индексация для " + e.getFullName() +
                            " произведена успешно, и теперь ЗП составляет: " + e.getSalary());
                    System.out.println("Было: " + (int) tmp);
                }
            }
        }
    }

    public void indexSalariesByDepartment(int percent, int department) {
        for (Employee e : employees[department - 1]) {
            if (e != null) {
                int tmp = e.getSalary();
                e.setSalary(e.getSalary() * ((percent / 100) + 1));
                System.out.println("Индексация для " + e.getFullName() +
                        " произведена успешно, и теперь ЗП составляет: " + e.getSalary());
                System.out.println("Было: " + tmp);
            }
        }
    }

    public void printEmployeesWithSalaryAbove(int salary) {
        for (Employee[] department : employees) {
            for (Employee e : department) {
                if (e != null) {
                    if (e.getSalary() >= salary) {
                        System.out.println(e);
                    }
                }
            }
        }
    }

    public void printEmployeesWithSalaryBelow(int salary) {
        for (Employee[] department : employees) {
            for (Employee e : department) {
                if (e != null) {
                    if (e.getSalary() < salary) {
                        System.out.println(e);
                    }
                }
            }
        }
    }

    public boolean equalsEmployee(Employee firstEmployee, Employee secondEmployee) {
        return firstEmployee.equals(secondEmployee);
    }
}
