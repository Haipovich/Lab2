import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the number of task(1-6):");
            switch (scan.nextInt()) {
                case 1:
                    Name nm1 = new Name("Клеопатра");
                    Name nm2 = new Name("Пушкин", "Александр", "Сергеевич");
                    Name nm3 = new Name("Маяковский", "Владимир");
                    System.out.println(nm1);
                    System.out.println(nm2);
                    System.out.println(nm3);
                    break;
                case 2:
                    House home = new House(scan.nextInt());
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
                    System.out.println(kozlov.get_department().get_employees());
                    break;
                case 5:
                    Name_new nmw1 = new Name_new("Клеопатра");
                    Name_new nmw2 = new Name_new("Александр", "Сергеевич", "Пушкин");
                    Name_new nmw3 = new Name_new("Владимир", "Маяковский");
                    Name_new nmw4 = new Name_new("Христофор", "Бонифатьевич");
                    System.out.println(nmw1);
                    System.out.println(nmw2);
                    System.out.println(nmw3);
                    System.out.println(nmw4);
                    break;
                case 6:
                    System.out.println("Enter 3 fraction in format(x y):");
                    Fraction f1 = new Fraction(scan.nextInt(), scan.nextInt());
                    Fraction f2 = new Fraction(scan.nextInt(), scan.nextInt());
                    Fraction f3 = new Fraction(scan.nextInt(), scan.nextInt());
                    System.out.println(f1 + " + " + f2 + " = " + f1.sum(f2));
                    System.out.println(f1 + " - " + f2 + " = " + f1.minus(f2));
                    System.out.println(f1 + " * " + f3 + " = " + f1.multiply(f3));
                    System.out.println(f3 + " / " + f2 + " = " + f3.divide(f2));
                    System.out.println(f1.sum(f2).divide(f3).minus(5));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value");
            }
        }
    }
}