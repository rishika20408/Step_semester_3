import java.util.*;

abstract class StudentFee {
    String name;

    static final double TRANSPORT_FEE = 12000;

    StudentFee(String name) {
        this.name = name;
    }

    abstract double getTuition();

    boolean usesBus() {
        return false;
    }

    double getTotalFee() {
        double total = getTuition();

        if (usesBus()) {
            total += TRANSPORT_FEE;
        }

        return total;
    }
}

class DayScholar extends StudentFee {
    DayScholar(String name) {
        super(name);
    }

    double getTuition() {
        return 40000;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends StudentFee {
    Hosteller(String name) {
        super(name);
    }

    double getTuition() {
        return 40000 + 60000;
    }
}

class Scholar extends StudentFee {
    Scholar(String name) {
        super(name);
    }

    double getTuition() {
        return 20000;
    }

    boolean usesBus() {
        return true;
    }
}

public class CollegeFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            StudentFee student;

            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else {
                student = new Scholar(name);
            }

            double fee = student.getTotalFee();

            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
    }
}