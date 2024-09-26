package DungeonGame.Models;

import DungeonGame.Enums.Direction;

public class Adventurer {
    private Position position;

    public Adventurer(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    // logic to move adventurer based on the direction
    public void move(Direction direction) {
        switch (direction) {
            case NORTH: {
                position.setY(position.getY() - 1);
                break;
            }

            case SOUTH: {
                position.setY(position.getY() + 1);
                break;
            }

            case EAST: {
                position.setX(position.getX() + 1);
                break;
            }

            case WEST: {
                position.setX(position.getX() - 1);
                break;
            }
        }
    }
}
