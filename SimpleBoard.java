import java.util.HashMap;
import java.util.Map;

public class SimpleBoard implements Board {
    private final int size;
    private final Map<Integer, Integer> specialPositions;

    public SimpleBoard(int size) {
        this.size = size;
        this.specialPositions = new HashMap<>();
        initializeSpecialPositions();
    }

    private void initializeSpecialPositions() {
        // Add ladders
        specialPositions.put(3, 22);
        specialPositions.put(20, 29);

        // Add snakes
        specialPositions.put(17, 7);
        specialPositions.put(54, 34);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getNewPosition(int position) {
        if (specialPositions.containsKey(position)) {
            int newPosition = specialPositions.get(position);
            if (newPosition > position) {
                System.out.println("Hurray! You climbed a ladder from " + position + " to " + newPosition);
            } else {
                System.out.println("Oops! You got bitten by a snake and slid from " + position + " to " + newPosition);
            }
            return newPosition;
        }
        return position;
    }
}
