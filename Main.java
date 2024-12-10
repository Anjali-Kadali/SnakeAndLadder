import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get board size
        System.out.print("Enter the size of the board: ");
        int boardSize = scanner.nextInt();

        // Get number of players
        System.out.print("Enter the number of players: ");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // Get player names
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Enter the name of player " + i + ": ");
            String playerName = scanner.nextLine();
            players.add(new SimplePlayer(playerName));
        }

        // Create board and dice
        Board board = new SimpleBoard(boardSize);
        Dice dice = new SimpleDice(6); // Dice with 6 sides

        // Create and start the game
        Player[] playersArray = players.toArray(new Player[0]);
        Game game = new SnakeandLadder(playersArray, board, dice);
        game.play();

        scanner.close();
    }
}
