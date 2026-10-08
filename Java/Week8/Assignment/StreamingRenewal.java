import java.time.LocalDate;
import java.util.*;

abstract class Plan {
    abstract int getDays();
}

class Basic extends Plan {
    int getDays() {
        return 30;
    }
}

class Standard extends Plan {
    int getDays() {
        return 90;
    }
}

class Premium extends Plan {
    int getDays() {
        return 365;
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            Plan plan;

            if (type.equals("BASIC")) {
                plan = new Basic();
            } else if (type.equals("STANDARD")) {
                plan = new Standard();
            } else {
                plan = new Premium();
            }

            LocalDate renewalDate = startDate.plusDays(plan.getDays());

            System.out.println(name + ": " + renewalDate);
        }
    }
}