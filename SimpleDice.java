import java.util.Random;

public class SimpleDice implements Dice {
    private final int sides;
    private final Random random;

    public SimpleDice(int sides) {
        this.sides = sides;
        this.random = new Random();
    }

    @Override
    public int roll() {
        return random.nextInt(sides) + 1; // Random number between 1 and sides
    }
}
