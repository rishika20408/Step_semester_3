import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static String getComputerMove(Random random) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        int index = random.nextInt(moves.length);
        return moves[index];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int TOTAL_ROUNDS = 5;

        String[] playerMoves = new String[TOTAL_ROUNDS];
        String[] computerMoves = new String[TOTAL_ROUNDS];
        String[] results = new String[TOTAL_ROUNDS];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int round = 0; round < TOTAL_ROUNDS; round++) {
            System.out.print("Round " + (round + 1) +
                    " - Enter Rock, Paper, or Scissors: ");

            String playerMove = scanner.nextLine();

            while (!playerMove.equalsIgnoreCase("Rock") &&
                   !playerMove.equalsIgnoreCase("Paper") &&
                   !playerMove.equalsIgnoreCase("Scissors")) {

                System.out.print("Invalid move. Enter Rock, Paper, or Scissors: ");
                playerMove = scanner.nextLine();
            }

            playerMove = playerMove.substring(0, 1).toUpperCase()
                    + playerMove.substring(1).toLowerCase();

            String computerMove = getComputerMove(random);
            String result = playRound(playerMove, computerMove);

            playerMoves[round] = playerMove;
            computerMoves[round] = computerMove;
            results[round] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);
        }

        double winPercentage = (double) wins / TOTAL_ROUNDS * 100;

        System.out.println("\nFinal Summary");
        System.out.println("-----------------------------------------------");
        System.out.printf("%-8s %-15s %-15s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int round = 0; round < TOTAL_ROUNDS; round++) {
            System.out.printf("%-8d %-15s %-15s %-15s%n",
                    round + 1,
                    playerMoves[round],
                    computerMoves[round],
                    results[round]);
        }

        System.out.println("-----------------------------------------------");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.2f%%%n", winPercentage);

        scanner.close();
    }
}