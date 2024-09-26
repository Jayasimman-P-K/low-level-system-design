package DungeonGame.Models;

import java.util.List;

public class Dungeon {
    private final int height, width;
    private final Treasure treasure;
    private final Trigger trigger;
    private final List<Pit> pits;

    public Dungeon(int height, int width, Treasure treasure, Trigger trigger, List<Pit> pits) {
        this.height = height;
        this.width = width;
        this.treasure = treasure;
        this.trigger = trigger;
        this.pits = pits;
    }

    public boolean isPositionValid(Position position) {
        return position.getX() >= 0 && position.getX() < width && position.getY() >= 0 && position.getY() < height;
    }

    public boolean isPitAtPosition(Position position) {
        return pits.stream().anyMatch(pit -> pit.getPosition().equals(position));
    }

    public boolean isTriggerAtPosition(Position position) {
        return position.equals(trigger.getPosition());
    }

    public Position getTreasurePosition() {
        return treasure.getPosition();
    }

    public boolean isTreasureAtPosition(Position position) {
        return position.equals(treasure.getPosition());
    }
}
