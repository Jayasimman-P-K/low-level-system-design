package Chess.Models;

import Chess.Models.Pieces.Bishop;
import Chess.Models.Pieces.King;
import Chess.Models.Pieces.Knight;
import Chess.Models.Pieces.Pawn;
import Chess.Models.Pieces.Queen;
import Chess.Models.Pieces.Rook;

public class Board {

    private Cell[][] cells;

    public Board() {
        cells = new Cell[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        // Initialize pawn pieces of white and black
        for (int j = 0; j < 8; j++) {
            cells[1][j] = new Cell(1, j, new Pawn(true));
            cells[6][j] = new Cell(6, j, new Pawn(false));
        }

        // Initialize white Pieces
        cells[0][0] = new Cell(0, 0, new Rook(true));
        cells[0][1] = new Cell(0, 1, new Knight(true));
        cells[0][2] = new Cell(0, 2, new Bishop(true));
        cells[0][3] = new Cell(0, 3, new Queen(true));
        cells[0][4] = new Cell(0, 4, new King(true));
        cells[0][5] = new Cell(0, 5, new Bishop(true));
        cells[0][6] = new Cell(0, 6, new Knight(true));
        cells[0][7] = new Cell(0, 7, new Rook(true));

        // Initialize black Pieces
        cells[7][0] = new Cell(7, 0, new Rook(false));
        cells[7][1] = new Cell(7, 1, new Knight(false));
        cells[7][2] = new Cell(7, 2, new Bishop(false));
        cells[7][3] = new Cell(7, 3, new Queen(false));
        cells[7][4] = new Cell(7, 4, new King(false));
        cells[7][5] = new Cell(7, 5, new Bishop(false));
        cells[7][6] = new Cell(7, 6, new Knight(false));
        cells[7][7] = new Cell(7, 7, new Rook(false));

        // Initiating remaining empty cells
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new Cell(i, j, null);
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (cells[i][j].getPiece() != null) {
                    System.out.print(cells[i][j].getPiece().getSymbol() + " ");
                } else {
                    System.out.print("- ");
                }
            }  
            System.out.println("");      
        }
    }

    public Cell getCell(int x, int y) {
        if (x < 0 || x >= 8 || y < 0 || y >= 8) {
            return null; // Ensure the cell coordinates are within the board
        }
        return cells[x][y];
    }

    public boolean isValidCell(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}


