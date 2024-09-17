package Chess.Models.Pieces;

import Chess.Models.Board;
import Chess.Models.Cell;
import Chess.Models.Piece;

public class Rook extends Piece{
    
    public Rook(boolean isWhite) {
        super(isWhite);
    }

    public boolean canMove(Board board, Cell initialCell, Cell finalCell) {
        int diffInX = Math.abs(initialCell.getX() - finalCell.getX());
        int diffInY = Math.abs(initialCell.getY() - finalCell.getY());

        if (diffInX == 0 || diffInY == 0) {
            return isPathClear(board, initialCell, finalCell) ;
        }

        return false;
    }

    public boolean isPathClear(Board board, Cell initialCell, Cell finalCell) {
        int xDirection = Integer.compare(finalCell.getX(), initialCell.getX());
        int yDirection = Integer.compare(finalCell.getY(), initialCell.getY());

        int x = initialCell.getX() + xDirection;
        int y = initialCell.getY() + yDirection;

        while (x != finalCell.getX() || y != finalCell.getY()) {
            if (board.getCell(x, y).getPiece() != null) {
                return false;
            }
            x += xDirection;
            y += yDirection;
        }

        return true;
    }

    public String getSymbol() {
        return isWhite() ? "R" : "r";
    }
}
