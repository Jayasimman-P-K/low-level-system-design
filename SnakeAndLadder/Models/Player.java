package SnakeAndLadder.Models;

import java.util.UUID;

public class Player {
    private final String playerName;
    private final String playerId;

    public Player(String playerName) {
        this.playerName = playerName;
        this.playerId = UUID.randomUUID().toString();
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }
    
}
