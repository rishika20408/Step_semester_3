import java.util.Scanner;

public class DuplicateTeamNameFinder {

    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of teams: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        String[] teamNames = new String[size];

        System.out.println("Enter team names:");
        for (int i = 0; i < size; i++) {
            teamNames[i] = scanner.nextLine();
        }

        System.out.println(findDuplicateTeam(teamNames));

        scanner.close();
    }
}