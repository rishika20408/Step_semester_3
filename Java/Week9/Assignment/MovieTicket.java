import java.util.*;

abstract class Ticket {
    int count;
    static final double CONVENIENCE_FEE = 20;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    double getTotal() {
        return count * (getPrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 150;
    }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 250;
    }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 400;
    }
}

public class MovieTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();

            Ticket ticket;

            if (type.equals("REGULAR")) {
                ticket = new RegularTicket(count);
            } else if (type.equals("PREMIUM")) {
                ticket = new PremiumTicket(count);
            } else {
                ticket = new ReclinerTicket(count);
            }

            double amount = ticket.getTotal();

            System.out.printf("%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}