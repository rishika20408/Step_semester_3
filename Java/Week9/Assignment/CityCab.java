import java.util.*;

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    boolean hasNightService() {
        return false;
    }

    double getFare(String time) {
        double fare = km * getRate();

        if (fare < 100) {
            fare = 100;
        }

        if (time.equals("NIGHT")) {
            fare = fare * 1.20;
        }

        return fare;
    }
}

class MiniCab extends Cab {
    MiniCab(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }
}

class SedanCab extends Cab {
    SedanCab(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    boolean hasNightService() {
        return true;
    }
}

class SUVCab extends Cab {
    SUVCab(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    boolean hasNightService() {
        return true;
    }
}

public class CityCab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI")) {
                cab = new MiniCab(km);
            } else if (type.equals("SEDAN")) {
                cab = new SedanCab(km);
            } else {
                cab = new SUVCab(km);
            }

            if (time.equals("NIGHT") && !cab.hasNightService()) {
                System.out.println(type + ": night service not available");
            } else {
                double fare = cab.getFare(time);

                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
    }
}