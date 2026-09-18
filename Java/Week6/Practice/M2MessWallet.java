class MessWallet {
    private double balance;

    MessWallet(double balance) {
        if (balance < 0) {
            System.out.println("Warning: Negative balance not allowed. Setting balance to 0.");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up amount must be greater than 0.");
        } else {
            balance += amount;
        }
    }

    void deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Deduction amount must be greater than 0.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
        }
    }

    double getBalance() {
        return balance;
    }
}

public class MessWallet {
    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(1000);

        wallet.topUp(500);
        wallet.deduct(300);

        System.out.println("Current Balance: " + wallet.getBalance());
    }
}