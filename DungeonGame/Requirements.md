# Dungeon Game - LLD

### Folder Structure

```css
DungeonGame
├── Models
│   ├── Adventurer.java
│   ├── Monster.java
│   ├── Dungeon.java
│   ├── Treasure.java
│   ├── Pit.java
│   ├── Trigger.java
│   └── Position.java  // For managing positions in the dungeon
├── Enum
│   └── Direction.java // Enum for directions (North, South, East, West)
├── Services
│   ├── GameService.java      // Game logic
│   ├── MovementService.java  // Handle movement of characters
│   └── CollisionService.java // Handle interactions between adventurer, monster, pits, etc.
├── Driver.java               // Main class to run the game
```
