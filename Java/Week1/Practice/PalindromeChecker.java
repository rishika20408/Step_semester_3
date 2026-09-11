import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        return checkRecursive(text, 0, text.length() - 1);
    }

    public static boolean checkRecursive(String text, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        return checkRecursive(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] characters = text.toCharArray();

        for (int i = 0; i < characters.length / 2; i++) {
            char temporary = characters[i];
            characters[i] = characters[characters.length - 1 - i];
            characters[characters.length - 1 - i] = temporary;
        }

        String reversedText = new String(characters);

        return text.equals(reversedText);
    }

    public static void printResult(String approach, boolean result) {
        if (result) {
            System.out.println(approach + ": Palindrome");
        } else {
            System.out.println(approach + ": Not Palindrome");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        boolean iterativeResult = isPalindromeIterative(text);
        boolean recursiveResult = isPalindromeRecursive(text);
        boolean arrayResult = isPalindromeArrayReversal(text);

        printResult("Iterative", iterativeResult);
        printResult("Recursive", recursiveResult);
        printResult("Array Reversal", arrayResult);

        scanner.close();
    }
}