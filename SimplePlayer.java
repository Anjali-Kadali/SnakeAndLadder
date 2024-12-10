public class SimplePlayer implements Player {
    private final String name;
    private int position;

    public SimplePlayer(String name) {
        this.name = name;
        this.position = 0; // Start at position 0
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }
}
