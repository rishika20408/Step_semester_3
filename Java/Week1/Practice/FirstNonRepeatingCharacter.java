import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingChar(String text) {
        for (int i = 0; i < text.length(); i++) {
            char currentCharacter = text.charAt(i);
            int frequency = 0;

            for (int j = 0; j < text.length(); j++) {
                if (currentCharacter == text.charAt(j)) {
                    frequency++;
                }
            }

            if (frequency == 1) {
                return currentCharacter;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        char result = findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }

        scanner.close();
    }
}