package DungeonGame.Services;

import DungeonGame.Models.*;

public class CollisionService {
    public boolean checkPitCollision(Adventurer adventurer, Dungeon dungeon) {
        if (dungeon.isPitAtPosition(adventurer.getPosition())) {
            System.out.println("Adventurer fell into a pit! Game Over.");
            return true;
        }
        return false;
    }

    public boolean checkMonsterCollision(Adventurer adventurer, Monster monster) {
        if (adventurer.getPosition().equals(monster.getPosition())) {
            System.out.println("Adventurer was caught by the monster! Game Over.");
            return true;
        }
        return false;
    }

    public boolean checkTreasureCollision(Adventurer adventurer, Dungeon dungeon) {
        if (dungeon.isTreasureAtPosition(adventurer.getPosition())) {
            System.out.println("Adventurer found the treasure! You win!");
            return true;
        }
        return false;
    }
}
