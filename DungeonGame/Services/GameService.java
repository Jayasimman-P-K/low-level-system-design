package DungeonGame.Services;

import DungeonGame.Enums.Direction;
import DungeonGame.Models.*;

import java.util.Scanner;

public class GameService {
    private MovementService movementService;
    private CollisionService collisionService;

    public GameService() {
        this.movementService = new MovementService();
        this.collisionService = new CollisionService();
    }

    public void startGame(Dungeon dungeon, Adventurer adventurer, Monster monster) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter direction to move (NORTH, SOUTH, EAST, WEST): ");
            Direction direction = Direction.valueOf(scanner.nextLine().toUpperCase());

            movementService.moveAdventurer(adventurer, direction, dungeon);

            // Check for collisions
            if (collisionService.checkPitCollision(adventurer, dungeon) || 
                collisionService.checkMonsterCollision(adventurer, monster) ||
                collisionService.checkTreasureCollision(adventurer, dungeon)) {
                break;
            }

            // Move the monster
            movementService.moveMonster(monster, adventurer);
        }

        scanner.close();
    }
}
