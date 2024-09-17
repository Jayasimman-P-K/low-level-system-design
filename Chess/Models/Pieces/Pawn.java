package Chess.Models.Pieces;

import Chess.Models.Board;
import Chess.Models.Cell;
import Chess.Models.Piece;

public class Pawn extends Piece {
    
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    public boolean canMove(Board board, Cell initialCell, Cell finalCell) {
        int direction = isWhite() ? 1 : -1;
        int initiaCellX = initialCell.getX();
        int initiaCellY = initialCell.getY();
        int finalCellX = finalCell.getX();
        int finalCellY = finalCell.getY();

        // single move forword
        if (initiaCellX + direction == finalCellX && initiaCellY == finalCellY && finalCell.getPiece() == null) {
            return true;
        }

        // double move forward from starting position
        if (initiaCellX + (direction * 2) == finalCellX && initiaCellY == finalCellY && finalCell.getPiece() == null && initiaCellX == (isWhite() ? 1 : 6)) {
            return true;
        }

        // capture move
        if (initiaCellX + direction == finalCellX && Math.abs(initiaCellY - finalCellY) == 1 && finalCell.getPiece() != null && finalCell.getPiece().isWhite() != isWhite()) {
            return true;
        }

        return false;
    }

    public String getSymbol() {
        return isWhite() ? "P" : "p";
    }
}
