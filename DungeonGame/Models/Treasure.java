package DungeonGame.Models;

public class Treasure {
    private final Position position;

    public Treasure(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }

}
