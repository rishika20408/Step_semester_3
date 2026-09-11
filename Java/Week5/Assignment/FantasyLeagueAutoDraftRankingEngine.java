import java.util.Arrays;
import java.util.Scanner;

public class FantasyLeagueAutoDraftRankingEngine
        implements Comparable<FantasyLeagueAutoDraftRankingEngine> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public FantasyLeagueAutoDraftRankingEngine(String name,
                                               int matchesPlayed,
                                               double battingAverage,
                                               boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(FantasyLeagueAutoDraftRankingEngine other) {
        return Double.compare(
                other.battingAverage,
                this.battingAverage
        );
    }

    static String draftAndRank(
            FantasyLeagueAutoDraftRankingEngine[] players) {

        int count = 0;

        for (FantasyLeagueAutoDraftRankingEngine player : players) {
            if (isDraftable(player.matchesPlayed)
                    || isDraftable(player.matchesPlayed, player.injured)) {
                count++;
            }
        }

        FantasyLeagueAutoDraftRankingEngine[] draftable =
                new FantasyLeagueAutoDraftRankingEngine[count];

        int index = 0;

        for (FantasyLeagueAutoDraftRankingEngine player : players) {
            if (isDraftable(player.matchesPlayed)
                    || isDraftable(player.matchesPlayed, player.injured)) {
                draftable[index++] = player;
            }
        }

        Arrays.sort(draftable);

        String result = "";

        for (int i = 0; i < draftable.length; i++) {
            result += (i + 1) + ". " + draftable[i].name;

            if (i < draftable.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        FantasyLeagueAutoDraftRankingEngine[] players =
                new FantasyLeagueAutoDraftRankingEngine[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter player name: ");
            String name = scanner.nextLine();

            System.out.print("Enter matches played: ");
            int matchesPlayed = scanner.nextInt();

            System.out.print("Enter batting average: ");
            double battingAverage = scanner.nextDouble();

            System.out.print("Is player injured? (true/false): ");
            boolean injured = scanner.nextBoolean();
            scanner.nextLine();

            players[i] =
                    new FantasyLeagueAutoDraftRankingEngine(
                            name,
                            matchesPlayed,
                            battingAverage,
                            injured
                    );
        }

        System.out.println(draftAndRank(players));

        scanner.close();
    }
}