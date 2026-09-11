import java.util.Arrays;
import java.util.Scanner;

public class PlacementDriveRankingEngine implements Comparable<PlacementDriveRankingEngine> {

    private String name;
    private double cgpa;
    private int codingScore;

    public PlacementDriveRankingEngine(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    private double getCompositeScore() {
        return (cgpa * 10) + (codingScore * 0.5);
    }

    @Override
    public int compareTo(PlacementDriveRankingEngine other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    static String shortlistAndRank(PlacementDriveRankingEngine[] candidates) {
        int count = 0;

        for (PlacementDriveRankingEngine candidate : candidates) {
            if (isEligible(candidate.cgpa)
                    || isEligible(candidate.cgpa, candidate.codingScore)) {
                count++;
            }
        }

        PlacementDriveRankingEngine[] shortlisted =
                new PlacementDriveRankingEngine[count];

        int index = 0;

        for (PlacementDriveRankingEngine candidate : candidates) {
            if (isEligible(candidate.cgpa)
                    || isEligible(candidate.cgpa, candidate.codingScore)) {
                shortlisted[index++] = candidate;
            }
        }

        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {
            result += (i + 1) + ". "
                    + shortlisted[i].name
                    + " (" + shortlisted[i].getCompositeScore() + ")";

            if (i < shortlisted.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        PlacementDriveRankingEngine[] candidates =
                new PlacementDriveRankingEngine[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter candidate name: ");
            String name = scanner.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = scanner.nextDouble();

            System.out.print("Enter coding score: ");
            int codingScore = scanner.nextInt();
            scanner.nextLine();

            candidates[i] =
                    new PlacementDriveRankingEngine(name, cgpa, codingScore);
        }

        System.out.println(shortlistAndRank(candidates));

        scanner.close();
    }
}