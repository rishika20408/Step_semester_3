import java.util.*;

abstract class Travel {
    static final double BOOKING_FEE = 50;
    double distance;

    Travel(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double getTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class BusTravel extends Travel {
    BusTravel(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 2;
    }
}

class TrainTravel extends Travel {
    TrainTravel(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 1.5;
    }
}

class FlightTravel extends Travel {
    FlightTravel(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 2500 + distance * 4;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            Travel travel;

            if (type.equals("BUS")) {
                travel = new BusTravel(distance);
            } else if (type.equals("TRAIN")) {
                travel = new TrainTravel(distance);
            } else {
                travel = new FlightTravel(distance);
            }

            System.out.printf("%s: %.2f%n", type, travel.getTotal());
        }
    }
}