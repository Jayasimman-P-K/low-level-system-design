package DungeonGame.Models;

public class Trigger {
    private final Position position;

    public Trigger(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }
}
