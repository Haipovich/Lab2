package ru.khismatov;

import java.util.InputMismatchException;
import java.util.Scanner;
import ru.Khismatov.Name.Name;
import ru.Khismatov.Name.NameNew;
import ru.Khismatov.House.House;
import ru.Khismatov.Employee.Department;
import ru.Khismatov.Employee.Employee;
import ru.Khismatov.Math.Fraction;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the number of task (1-6), or 0 to exit:");
            int taskNumber = -1;
            try {
                if (scan.hasNextInt()) {
                    taskNumber = scan.nextInt();
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scan.nextLine();
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer value.");
                scan.nextLine();
                continue;
            }

            if (taskNumber == 0) {
                System.out.println("Exiting program.");
                break;
            }

            switch (taskNumber) {
                case 1:
                    Name nm1 = new Name("Клеопатра");
                    Name nm2 = new Name("Пушкин", "Александр", "Сергеевич");
                    Name nm3 = new Name("Маяковский", "Владимир");
                    System.out.println(nm1);
                    System.out.println(nm2);
                    System.out.println(nm3);
                    break;
                case 2:
                    System.out.println("Enter the number of floors:");
                    int numFloors = 0;
                    try {
                        if (scan.hasNextInt()) {
                            numFloors = scan.nextInt();
                        } else {
                            System.out.println("Invalid input for floors. Please enter a number.");
                            scan.nextLine();
                            continue;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input for floors. Please enter an integer value.");
                        scan.nextLine();
                        continue;
                    }
                    House home = new House(numFloors);
                    System.out.println(home);
                    break;
                case 3:
                    Department departmentIT = new Department("IT");
                    Employee kozlov = new Employee("Kozlov", departmentIT);
                    Employee sidorov = new Employee("Sidorov", departmentIT);
                    Employee petrov = new Employee("Petrov", departmentIT);
                    departmentIT.setHead(kozlov);
                    System.out.println(sidorov);
                    System.out.println(kozlov);
                    System.out.println(petrov);
                    break;
                case 4:
                    departmentIT = new Department("IT");
                    kozlov = new Employee("Kozlov", departmentIT);
                    sidorov = new Employee("Sidorov", departmentIT);
                    petrov = new Employee("Petrov", departmentIT);
                    departmentIT.setHead(kozlov);
                    if (kozlov.getDepartment() != null) {
                         System.out.println(kozlov.getDepartment().getEmployeeNames());
                    } else {
                         System.out.println("Error: Kozlov's department is not initialized.");
                    }
                    break;
                case 5:
                    NameNew nmw1 = new NameNew("Клеопатра");
                    NameNew nmw2 = new NameNew("Александр", "Сергеевич", "Пушкин");
                    NameNew nmw3 = new NameNew("Владимир", "Маяковский");
                    NameNew nmw4 = new NameNew("Христофор", "Бонифатьевич");
                    System.out.println(nmw1);
                    System.out.println(nmw2);
                    System.out.println(nmw3);
                    System.out.println(nmw4);
                    break;
                case 6:
                    System.out.println("Enter 3 fractions in format (numerator denominator) separated by spaces or newlines:");
                    Fraction f1 = null, f2 = null, f3 = null;
                    try {
                        System.out.print("Fraction 1 (num den): ");
                        f1 = new Fraction(scan.nextInt(), scan.nextInt());
                        System.out.print("Fraction 2 (num den): ");
                        f2 = new Fraction(scan.nextInt(), scan.nextInt());
                        System.out.print("Fraction 3 (num den): ");
                        f3 = new Fraction(scan.nextInt(), scan.nextInt());
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input for fraction. Please enter integer values for numerator and denominator.");
                        scan.nextLine();
                        continue;
                    }
                    if (f1 != null && f2 != null && f3 != null) {
                        System.out.println(f1 + " + " + f2 + " = " + f1.sum(f2));
                        System.out.println(f1 + " - " + f2 + " = " + f1.minus(f2));
                        System.out.println(f1 + " * " + f3 + " = " + f1.multiply(f3));
                        System.out.println(f3 + " / " + f2 + " = " + f3.divide(f2));
                        System.out.println("((" + f1 + " + " + f2 + ") / " + f3 + ") - 5 = " + f1.sum(f2).divide(f3).minus(5));
                    }
                    break;
                default:
                    System.out.println("Unexpected value. Please enter a number between 1 and 6, or 0 to exit.");
            }
        }
        scan.close();
    }
}
