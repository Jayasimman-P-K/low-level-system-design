package Chess.Models.Pieces;

import Chess.Models.Board;
import Chess.Models.Cell;
import Chess.Models.Piece;

public class King extends Piece {

    public King(boolean isWhite) {
        super(isWhite);
    }

    public boolean canMove(Board board, Cell initialCell, Cell finalCell) {
        int diffInX = Math.abs(initialCell.getX() - finalCell.getX());
        int diffInY = Math.abs(initialCell.getY() - finalCell.getY());

        return (diffInX <= 1 && diffInY <= 1);
    }

    public String getSymbol() {
        return isWhite() ? "K" : "k";
    }
    
}
