import java.util.Arrays;
import java.util.Scanner;

public class HackathonScoreCurveBooster {

    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
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

        System.out.print("Enter bonus: ");
        int bonus = scanner.nextInt();

        curveScores(scores, bonus);

        System.out.println(Arrays.toString(scores));

        scanner.close();
    }
}