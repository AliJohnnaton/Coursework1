import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EmployeeBook book = new EmployeeBook();
        while (true) {
            System.out.println();
            System.out.println("Выберите действие:");
            System.out.println("1) Добавить сотрудника");
            System.out.println("2) Удалить сотрудника");
            System.out.println("3) Вывести список сотрудников");
            System.out.println("4) Вывести сумму затрат на ЗП");
            System.out.println("5) Вывести сотрудника с минимальной ЗП");
            System.out.println("6) Вывести сотрудника с максимальной ЗП");
            System.out.println("7) Вывести средний уровень ЗП среди сотрудников");
            System.out.println("8) Вывести сотрудника по ID");
            System.out.println("9) Произвести индексацию ЗП в %");
            System.out.println("10) Вывести список сотрудников, у которых ЗП больше или равна указаной");
            System.out.println("11) Вывести список сотрудников, у которых ЗП меньше указаной");
            System.out.println("12) Сравнить двух сотрудников");
            System.out.println("0) Выход");
            int tmp = book.checkValidationInt(0, 12);
            if ((tmp > 1 && tmp <= 12) && book.numberOfEmployees() == 0) {
                System.out.println("В базе не хватает сотрудников!");
            } else {
                switch (tmp) {
                    case 0: {
                        System.exit(0);
                    }
                    case 1: {
                        System.out.print("Введите имя: ");
                        String name = scanner.nextLine();
                        name = book.checkValidationString(name);

                        System.out.print("Введите фамилию: ");
                        String surname = scanner.nextLine();
                        surname = book.checkValidationString(surname);

                        System.out.print("Введите отчество: ");
                        String fathername = scanner.nextLine();
                        fathername = book.checkValidationString(fathername);

                        System.out.print("Введите ЗП: ");
                        int salary = book.checkValidationInt(1, 200000);

                        System.out.println("Введите отдел");
                        int department = book.checkValidationInt(1, 5);

                        Employee employee = new Employee(surname, name, fathername, salary, department);
                        if (book.addEmployee(employee)) {
                            System.out.println("Сотрудник успешно добавлен");
                        } else {
                            System.out.println("В этом отделе нет места");
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Введите id сотрудника: ");
                        int id = book.checkValidationID();
                        book.removeEmployee(id);
                        System.out.println("Сотрудник был удалён из базы данных");
                        break;
                    }
                    case 3: {
                        bookPrint(book);
                        break;
                    }
                    case 4: {
                        sumPrint(book);
                        break;
                    }
                    case 5: {
                        minPrint(book);
                        break;
                    }
                    case 6: {
                        maxPrint(book);
                        break;
                    }
                    case 7: {
                        averagePrint(book);
                        break;
                    }
                    case 8: {
                        System.out.println("Введите id сотрудника: ");
                        int id = book.checkValidationID();
                        if (book.getEmployee(id) != null) {
                            System.out.println(book.getEmployee(id));
                        } else {
                            System.out.println("В базе нет сотрудника с таким ID");
                        }
                        break;
                    }
                    case 9: {
                        indexPrint(book);
                        break;
                    }
                    case 10: {
                        System.out.print("Введите уровень ЗП для поиска:");
                        int salary = book.checkValidationInt(1, 200000);
                        System.out.println("Список сотрудников с ЗП больше или равной указанной");
                        book.printEmployeesWithSalaryAbove(salary);
                        break;
                    }
                    case 11: {
                        System.out.print("Введите уровень ЗП для поиска:");
                        int salary = book.checkValidationInt(1, 200000);
                        System.out.println("Список сотрудников с ЗП меньше указанной");
                        book.printEmployeesWithSalaryBelow(salary);
                        break;
                    }
                    case 12: {
                        System.out.println("Введите id первого сотрудника: ");
                        int firstID = book.checkValidationID();
                        Employee firstEmployee;
                        if (book.getEmployee(firstID) != null) {
                            System.out.println(book.getEmployee(firstID));
                            firstEmployee = book.getEmployee(firstID);
                        } else {
                            System.out.println("В базе нет сотрудника с таким ID");
                            break;
                        }
                        System.out.println("Введите id второго сотрудника: ");
                        int secondID = book.checkValidationID();
                        Employee secondEmployee;
                        if (book.getEmployee(secondID) != null) {
                            System.out.println(book.getEmployee(secondID));
                            secondEmployee = book.getEmployee(secondID);
                        } else {
                            System.out.println("В базе нет сотрудника с таким ID");
                            break;
                        }
                        if (book.equalsEmployee(firstEmployee, secondEmployee)) {
                            System.out.println("Люди под этими ID равны");
                        } else {
                            System.out.println("Люди под этими ID не равны");
                        }
                    }
                }
            }
        }
    }

    public static void bookPrint(EmployeeBook book) {
        System.out.println("\nПроизвести операцию на всех или на конкретный отдел?\n1) Все\n2) На отдел");
        int tmp = book.checkValidationInt(1, 2);
        switch (tmp) {
            case 1: {
                book.printAllEmployees();
                break;
            }
            case 2: {
                System.out.println("Введите отдел: ");
                int dep = book.checkValidationInt(1, 5);
                book.printEmployeesByDepartment(dep);
                break;
            }
        }
    }

    public static void sumPrint(EmployeeBook book) {
        System.out.println("\nПроизвести операцию на всех или на конкретный отдел?\n1) Все\n2) На отдел");
        int tmp = book.checkValidationInt(1, 2);
        switch (tmp) {
            case 1: {
                System.out.println("Сумма затрат на ЗП на всех сотрудников: " + book.sumSalary() + " $");
                break;
            }
            case 2: {
                System.out.println("Введите отдел: ");
                int department = book.checkValidationInt(1, 5);
                if (book.numberOfEmployeesByDepartment(department) != 0) {
                    System.out.println("Сумма затрат на ЗП на сотрудников из " + department + " отдела: " +
                            book.sumSalaryByDepartment(department) + " $");
                } else {
                    System.out.println("В " + department + " офисе критически мало сотрудников");
                }
                break;
            }
        }
    }

    public static void minPrint(EmployeeBook book) {
        System.out.println("\nПроизвести операцию на всех или на конкретный отдел?\n1) Все\n2) На отдел");
        int tmp = book.checkValidationInt(1, 2);
        switch (tmp) {
            case 1: {
                System.out.println("Самая маленькая ЗП среди всех сотрудников у " + book.minSalary());
                break;
            }
            case 2: {
                System.out.println("Введите отдел: ");
                int department = book.checkValidationInt(1, 5);
                if (book.numberOfEmployeesByDepartment(department) != 0) {
                    System.out.println("Самая маленькая ЗП среди сотрудников" + department +
                            " отдела у " + book.minSalaryByDepartment(department));
                } else {
                    System.out.println("В " + department + " офисе критически мало сотрудников");
                }
                break;
            }
        }
    }

    public static void maxPrint(EmployeeBook book) {
        System.out.println("\nПроизвести операцию на всех или на конкретный отдел?\n1) Все\n2) На отдел");
        int tmp = book.checkValidationInt(1, 2);
        switch (tmp) {
            case 1: {
                System.out.println("Самая большая ЗП среди всех сотрудников у " + book.maxSalary());
                break;
            }
            case 2: {
                System.out.println("Введите отдел: ");
                int department = book.checkValidationInt(1, 5);
                if (book.numberOfEmployeesByDepartment(department) != 0) {
                    System.out.println("Самая маленькая ЗП среди сотрудников" + department +
                            " отдела у " + book.maxSalaryByDepartment(department));
                } else {
                    System.out.println("В " + department + " офисе критически мало сотрудников");
                }
                break;
            }
        }
    }

    public static void averagePrint(EmployeeBook book) {
        System.out.println("\nПроизвести операцию на всех или на конкретный отдел?\n1) Все\n2) На отдел");
        int tmp = book.checkValidationInt(1, 2);
        switch (tmp) {
            case 1: {
                System.out.println("Среднее значение ЗП среди всех сотрудников: " + book.averageSalary() + " $");
                break;
            }
            case 2: {
                System.out.println("Введите отдел: ");
                int department = book.checkValidationInt(1, 5);
                System.out.println("Среднее значение ЗП среди сотрудников" + department + " отдела: " +
                        book.averageSalaryByDepartment(department) + " $");
                break;
            }
        }
    }

    public static void indexPrint(EmployeeBook book) {
        System.out.print("\nВведите процент индексации: ");
        int percent = book.checkValidationInt(0, 100);
        System.out.println("\nПроизвести операцию на всех или на конкретный отдел?\n1) Все\n2) На отдел");
        int tmp = book.checkValidationInt(1, 2);
        switch (tmp) {
            case 1: {
                book.indexSalaries(percent);
                break;
            }
            case 2: {
                System.out.print("Введите отдел: ");
                int dep = book.checkValidationInt(1, 5);
                book.indexSalariesByDepartment(percent, dep);
                break;
            }
        }
    }
}
