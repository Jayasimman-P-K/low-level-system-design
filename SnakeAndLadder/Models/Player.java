package SnakeAndLadder.Models;

import java.util.UUID;

public class Player {
    private String playerName;
    private String playerId;

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


