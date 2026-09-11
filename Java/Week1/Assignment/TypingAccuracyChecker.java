import java.util.Scanner;

public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {

        int totalCharacters = original.length();
        int matchedCharacters = 0;
        int firstMismatchPosition = -1;

        int comparisonLength = Math.min(original.length(), typed.length());

        for (int i = 0; i < comparisonLength; i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i;
            }
        }

        if (typed.length() != original.length() &&
            firstMismatchPosition == -1) {
            firstMismatchPosition = comparisonLength;
        }

        double accuracy = 0;

        if (totalCharacters > 0) {
            accuracy = (double) matchedCharacters / totalCharacters * 100;
        }

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%",
                matchedCharacters, totalCharacters, accuracy);

        if (firstMismatchPosition == -1) {
            System.out.println(" | No Mismatches");
        } else {
            char originalCharacter = original.charAt(firstMismatchPosition);

            char typedCharacter = firstMismatchPosition < typed.length()
                    ? typed.charAt(firstMismatchPosition)
                    : '-';

            System.out.println(" | First Mismatch at position "
                    + (firstMismatchPosition + 1)
                    + " ('" + originalCharacter
                    + "' vs '" + typedCharacter + "')");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = scanner.nextLine();

        System.out.print("Enter typed text: ");
        String typed = scanner.nextLine();

        checkTypingAccuracy(original, typed);

        scanner.close();
    }
}