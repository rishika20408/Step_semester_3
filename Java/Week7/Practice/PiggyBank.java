class PiggyBankData {
    private double savings;
    private final String id;

    PiggyBankData(String id) {
        this.id = id;
        savings = 0;
    }

    void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
        }
    }

    double getSavings() {
        return savings;
    }
}

public class PiggyBank {
    public static void main(String[] args) {
        PiggyBankData pb = new PiggyBankData("PB-1");

        pb.deposit(100);
        System.out.println("Savings: " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("Savings: " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Savings: " + pb.getSavings());
    }
}