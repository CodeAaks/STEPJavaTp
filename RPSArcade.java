import java.util.Random;
import java.util.Scanner;

public class RPSArcade {

    static String[] moves = {"Rock", "Paper", "Scissors"};

    public static void main(String[] args) {
        int N = 5;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[] playerMoves = new String[N];
        String[] computerMoves = new String[N];
        String[] results = new String[N];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < N; i++) {
            System.out.println("Round " + (i + 1) + ": Enter your move (Rock/Paper/Scissors):");
            String player = sc.nextLine().trim();
            String computer = moves[rand.nextInt(3)];

            String result = decide(player, computer);

            playerMoves[i] = player;
            computerMoves[i] = computer;
            results[i] = result;

            if (result.equals("Win")) wins++;
            else if (result.equals("Loss")) losses++;
            else draws++;

            System.out.println("Computer played: " + computer + " -> " + result);
        }

        System.out.println("\nRound | Player Move | Computer Move | Result");
        for (int i = 0; i < N; i++) {
            System.out.println((i + 1) + "     | " + playerMoves[i] + " | " + computerMoves[i] + " | " + results[i]);
        }

        double winPercent = (wins * 100.0) / N;
        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + winPercent + "%");
    }

    static String decide(String player, String computer) {
        if (player.equalsIgnoreCase(computer)) return "Draw";

        if ((player.equalsIgnoreCase("Rock") && computer.equalsIgnoreCase("Scissors")) ||
            (player.equalsIgnoreCase("Paper") && computer.equalsIgnoreCase("Rock")) ||
            (player.equalsIgnoreCase("Scissors") && computer.equalsIgnoreCase("Paper"))) {
            return "Win";
        }

        return "Loss";
    }
}