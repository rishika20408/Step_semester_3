import java.util.Scanner;

public class MovieReviewWordLengthProfiler {

    public static void classifyWordLengths(String review) {

        String[] words = review.trim().split("\\s+");

        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        for (String word : words) {

            String cleanWord = word.replaceAll("[^a-zA-Z]", "");

            int wordLength = cleanWord.length();

            if (wordLength >= 1 && wordLength <= 4) {
                shortWords++;
            } else if (wordLength <= 8) {
                mediumWords++;
            } else if (wordLength >= 9) {
                longWords++;
            }
        }

        System.out.println("Short: " + shortWords);
        System.out.println("Medium: " + mediumWords);
        System.out.println("Long: " + longWords);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter movie review: ");
        String review = scanner.nextLine();

        classifyWordLengths(review);

        scanner.close();
    }
}