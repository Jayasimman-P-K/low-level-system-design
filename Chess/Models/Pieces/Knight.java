package Chess.Models.Pieces;

import Chess.Models.Board;
import Chess.Models.Cell;
import Chess.Models.Piece;

public class Knight extends Piece{
    
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    public boolean canMove(Board board, Cell initialCell, Cell finalCell) {
        int diffInX = Math.abs(initialCell.getX() - finalCell.getX());
        int diffInY = Math.abs(initialCell.getY() - finalCell.getY());

        return (diffInX == 2 && diffInY == 1) || (diffInX == 1 && diffInY == 2);
    }

    public String getSymbol() {
        return isWhite() ? "N" : "n";
    }
}
