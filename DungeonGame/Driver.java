package DungeonGame;

import DungeonGame.Models.*;
import DungeonGame.Services.GameService;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        // Create dungeon with pits, treasure, and trigger
        Dungeon dungeon = new Dungeon(5, 5, new Treasure(3, 3), new Trigger(2, 2), Arrays.asList(new Pit(1, 1), new Pit(4, 4)));

        // Create adventurer and monster
        Adventurer adventurer = new Adventurer(0, 0);
        Monster monster = new Monster(4, 4);

        // Start the game
        GameService gameService = new GameService();
        gameService.startGame(dungeon, adventurer, monster);
    }
}
