package DungeonGame.Services;

import DungeonGame.Enums.Direction;
import DungeonGame.Models.Adventurer;
import DungeonGame.Models.Dungeon;
import DungeonGame.Models.Monster;

public class MovementService {
    public void moveAdventurer(Adventurer adventurer, Direction direction, Dungeon dungeon) {
        adventurer.move(direction);
        if (!dungeon.isPositionValid(adventurer.getPosition())) {
            System.out.println("Invalid move, out of bounds!!");
            return;
        }
    }

    public void moveMonster(Monster monster, Adventurer adventurer) {
        monster.moveTowardAdventurer(adventurer.getPosition());
    }
}
