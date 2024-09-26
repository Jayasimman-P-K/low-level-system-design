package DungeonGame.Models;

public class Pit {
    private final Position position;

    public Pit(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }
}
