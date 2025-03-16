import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static int fail(int a, int b) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите число от " + a + " до " + b + ": ");
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

    public static void bookPrint(EmployeeBook book) {
        System.out.println("\nПроизвести операцию на всех или на конкретный отдел?" +
                "\n1) Все" +
                "\n2) На отдел");
        int tmp = fail(1, 2);
        switch (tmp) {
            case 1:
                book.printEmployee();
                break;
            case 2: {
                System.out.println("Введите отдел: ");
                int dep = fail(1, 5);
                book.printEmployee(dep);
                break;
            }
        }
    }

    public static void sumPrint(EmployeeBook book) {
        System.out.println("\nПроизвести операцию на всех или на конкретный отдел?" +
                "\n1) Все" +
                "\n2) На отдел");
        int tmp = fail(1, 2);
        switch (tmp) {
            case 1:
                book.sumSalary();
                break;
            case 2: {
                System.out.println("Введите отдел: ");
                int dep = fail(1, 5);
                book.sumSalary(dep);
                break;
            }
        }
    }

    public static void minPrint(EmployeeBook book) {
        System.out.println("\nПроизвести операцию на всех или на конкретный отдел?" +
                "\n1) Все" +
                "\n2) На отдел");
        int tmp = fail(1, 2);
        switch (tmp) {
            case 1:
                book.minSalary();
                break;
            case 2: {
                System.out.println("Введите отдел: ");
                int dep = fail(1, 5);
                book.minSalary(dep);
                break;
            }
        }
    }

    public static void maxPrint(EmployeeBook book) {
        System.out.println("\nПроизвести операцию на всех или на конкретный отдел?" +
                "\n1) Все" +
                "\n2) На отдел");
        int tmp = fail(1, 2);
        switch (tmp) {
            case 1:
                book.maxSalary();
                break;
            case 2: {
                System.out.println("Введите отдел: ");
                int dep = fail(1, 5);
                book.maxSalary(dep);
                break;
            }
        }
    }

    public static void middlePrint(EmployeeBook book) {
        System.out.println("\nПроизвести операцию на всех или на конкретный отдел?" +
                "\n1) Все" +
                "\n2) На отдел");
        int tmp = fail(1, 2);
        switch (tmp) {
            case 1:
                book.middleSalary();
                break;
            case 2: {
                System.out.println("Введите отдел: ");
                int dep = fail(1, 5);
                book.middleSalary(dep);
                break;
            }
        }
    }

    public static void indexPrint(EmployeeBook book) {
        System.out.print("\nВведите процент индексации: ");
        int ind = fail(0, 100);
        System.out.println("\nПроизвести операцию на всех или на конкретный отдел?" +
                "\n1) Все" +
                "\n2) На отдел");
        int tmp = fail(1, 2);
        switch (tmp) {
            case 1:
                book.indexing(ind);
                break;
            case 2: {
                System.out.print("Введите отдел: ");
                int dep = fail(1, 5);
                book.indexing(ind, dep);
                break;
            }
        }
    }

    public static void editEmployee(EmployeeBook book) {
        System.out.println("\nВыберите действие:" +
                "\n1) Изменить отдел сотрудника" +
                "\n2) Изменить ЗП сотрудника" +
                "\n3) Вывести HashCode сотрудника" +
                "\n4) Вывести все данные по сотруднику" +
                "\n5) Сравнить двух сотрудников (equals) ");
        int tmp = fail(1, 6);
        if ((tmp > 0 && tmp <= 6) && book.getSize() == 0)
            System.out.println("В базе не хватает сотрудников!");
        else {
            switch (tmp) {
                case 1:
                    book.editDepartment();
                    break;
                case 2:
                    book.editSalary();
                    break;
                case 3:
                    book.getHashCode();
                    break;
                case 4:
                    book.getEmployee();
                    break;
                case 5:
                    book.equalsEmployee();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();
        while (true) {
            System.out.println("\nВыберите действие:" +
                    "\n1) Добавить сотрудника" +
                    "\n2) Удалить сотрудника" +
                    "\n3) Вывести список сотрудников" +
                    "\n4) Вывести сумму затрат на ЗП" +
                    "\n5) Вывести сотрудника с минимальной ЗП" +
                    "\n6) Вывести сотрудника с максимальной ЗП" +
                    "\n7) Вывести средний уровень ЗП среди сотрудников" +
                    "\n8) Вывести сотрудника по ID" +
                    "\n9) Произвести индексацию ЗП в %" +
                    "\n10) Вывести список сотрудников, у которых ЗП больше или равна указаной" +
                    "\n11) Вывести список сотрудников, у которых ЗП меньше указаной" +
                    "\n12) Редактировать сотрудника по ID" +
                    "\n0) Выход");
            int tmp = fail(0, 12);
            if ((tmp > 1 && tmp <= 12) && book.getSize() == 0)
                System.out.println("В базе не хватает сотрудников!");
            else {
                switch (tmp) {
                    case 0:
                        System.exit(0);
                    case 1:
                        book.add();
                        break;
                    case 2:
                        book.remove();
                        break;
                    case 3:
                        bookPrint(book);
                        break;
                    case 4:
                        sumPrint(book);
                        break;
                    case 5:
                        minPrint(book);
                        break;
                    case 6:
                        maxPrint(book);
                        break;
                    case 7:
                        middlePrint(book);
                        break;
                    case 8:
                        book.getEmployee();
                        break;
                    case 9:
                        indexPrint(book);
                        break;
                    case 10:
                        book.searchPlus();
                        break;
                    case 11:
                        book.searchMinus();
                        break;
                    case 12:
                        editEmployee(book);
                        break;
                }
            }
        }
    }
}
