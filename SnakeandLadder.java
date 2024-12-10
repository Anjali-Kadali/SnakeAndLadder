import java.util.Scanner;

public class SnakeandLadder implements Game {
    private final Player[] players;
    private final Board board;
    private final Dice dice;

    public SnakeandLadder(Player[] players, Board board, Dice dice) {
        this.players = players;
        this.board = board;
        this.dice = dice;
    }

    @Override
    public void play() {
        boolean gameWon = false;

        System.out.println("Welcome to Snake and Ladder!");

        while (!gameWon) {
            for (Player player : players) {
                System.out.println(player.getName() + "'s turn. Press Enter to roll the dice.");
                new Scanner(System.in).nextLine(); // Wait for user input

                int diceValue = dice.roll();
                System.out.println(player.getName() + " rolled a " + diceValue);

                int newPosition = player.getPosition() + diceValue;

                if (newPosition > board.getSize()) {
                    System.out.println(player.getName() + " stays at position " + player.getPosition());
                    continue;
                }

                newPosition = board.getNewPosition(newPosition);
                player.setPosition(newPosition);
                System.out.println(player.getName() + " is now at position " + player.getPosition());

                if (newPosition == board.getSize()) {
                    System.out.println(player.getName() + " wins the game!");
                    gameWon = true;
                    break;
                }
            }
        }
    }
}
