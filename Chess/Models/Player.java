package Chess.Models;

public class Player {
    private final String playerName;
    private final boolean isWhite;

    public Player (String playerName, boolean isWhite) {
        this.playerName = playerName;
        this.isWhite = isWhite;
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean isWhite() {
        return isWhite;
    }
}
