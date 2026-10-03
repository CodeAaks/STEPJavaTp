import java.util.*;

abstract class Employee {
    final String name;
    final double salary;
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    abstract double bonus();
}

class FullTime extends Employee {
    FullTime(String name, double salary) { super(name, salary); }
    double bonus() { return salary * 0.10; }
}

class PartTime extends Employee {
    PartTime(String name, double salary) { super(name, salary); }
    double bonus() { return salary * 0.05; }
}

class Intern extends Employee {
    Intern(String name, double salary) { super(name, salary); }
    double bonus() { return 2000; }
}

public class Main {
    static Employee of(String type, String name, double salary) {
        return switch (type) {
            case "FULLTIME" -> new FullTime(name, salary);
            case "PARTTIME" -> new PartTime(name, salary);
            default -> new Intern(name, salary);
        };
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> staff = new ArrayList<>();
        while (n-- > 0) {
            staff.add(of(sc.next(), sc.next(), sc.nextDouble()));
        }
        double total = 0;
        for (Employee e : staff) {
            total += e.bonus();
            System.out.printf("%s: %.2f%n", e.name, e.bonus());
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
