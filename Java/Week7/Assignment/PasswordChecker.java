class Password {
    private final String password;

    Password(String password) {
        this.password = password;
    }

    String getStrength() {
        if (password.length() < 6) {
            return "Weak";
        } else if (password.length() <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

public class PasswordChecker {
    public static void main(String[] args) {
        Password p1 = new Password("abcd");
        Password p2 = new Password("abcdefgh");
        Password p3 = new Password("abcdefghij");

        System.out.println(p1.getStrength());
        System.out.println(p2.getStrength());
        System.out.println(p3.getStrength());
    }
}