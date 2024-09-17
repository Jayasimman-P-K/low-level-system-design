package TicTacToe.Models;

public class Player {
    private final String playerName;
    private final char playerMark;

    public Player(String playerName, char playerMark) {
        this.playerName = playerName;
        this.playerMark = playerMark;
    }

    public String getPlayerName() {
        return playerName;
    }

    public char getPlayerMark() {
        return playerMark;
    }
    
}