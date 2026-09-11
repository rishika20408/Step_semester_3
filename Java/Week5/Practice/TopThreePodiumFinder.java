import java.util.Arrays;
import java.util.Scanner;

public class TopThreePodiumFinder {

    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score >= first) {
                third = second;
                second = first;
                first = score;
            } else if (score >= second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of scores: ");
        int size = scanner.nextInt();

        int[] scores = new int[size];

        System.out.println("Enter scores:");
        for (int i = 0; i < size; i++) {
            scores[i] = scanner.nextInt();
        }

        int[] result = findTopThreeScores(scores);

        System.out.println(Arrays.toString(result));

        scanner.close();
    }
}