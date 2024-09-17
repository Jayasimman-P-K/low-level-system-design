package Chess.Models;


public abstract class Piece {
    private boolean isWhite;
    private boolean isKilled = false;

    public Piece (boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean isKilled) {
        this.isKilled = isKilled;
    }

    public abstract boolean canMove(Board board, Cell initialCell, Cell finalCell);
    public abstract String getSymbol();
    
}
