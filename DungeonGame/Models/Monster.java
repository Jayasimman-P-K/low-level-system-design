package DungeonGame.Models;

public class Monster {
    private final Position position;

    public Monster(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }

    // logic to move the monster towards the adventurer
    public void moveTowardAdventurer(Position target) {
        // move by minimizing the Manhattan distance
        if (position.getX() < target.getX()) {
            position.setX(position.getX() + 1);
        } else if (position.getX() > target.getX()) {
            position.setX(position.getX() - 1);
        } else if (position.getY() < target.getY()) {
            position.setY(position.getY() + 1);
        } else if (position.getY() > target.getY()) {
            position.setY(position.getY() - 1);
        }
    }
}
