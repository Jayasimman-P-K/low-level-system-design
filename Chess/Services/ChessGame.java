package Chess.Services;

import java.util.Scanner;

import Chess.Enum.GameStatus;
import Chess.Models.Board;
import Chess.Models.Cell;
import Chess.Models.Piece;
import Chess.Models.Player;
import Chess.Models.Pieces.King;

public class ChessGame {
    private final Board board;
    private final Player whitePlayer;
    private final Player blackPlayer;
    private Player currPlayer;
    private GameStatus gameStatus;

    public ChessGame(String whitePlayerName, String blackPlayerName) {
        this.whitePlayer = new Player(whitePlayerName, true);
        this.blackPlayer = new Player(blackPlayerName, false);
        this.board = new Board();
        this.currPlayer = whitePlayer;
        this.gameStatus = GameStatus.ACTIVE;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        
        while (gameStatus == GameStatus.ACTIVE) {
            board.printBoard();
            System.out.println(currPlayer.getPlayerName() + "'s move(" + (currPlayer.isWhite() ? "white" : "black") +" player): ");

            System.out.print("Enter starting position(a1): ");
            String initialPosition = scanner.nextLine();
            System.out.print("Enter ending position(a1): ");
            String finalPosition = scanner.nextLine();

            int initialX = initialPosition.charAt(1) - '1';
            int initialY = initialPosition.charAt(0) - 'a';
            int finalX = finalPosition.charAt(1) - '1';
            int finalY = finalPosition.charAt(0) - 'a';
            
            Cell initialCell = board.getCell(initialX, initialY);
            Cell finalCell = board.getCell(finalX, finalY);

            if (initialCell == null || finalCell == null) {
                System.out.println("Invalid Input. Try again!!");
                continue;
            }

            Piece piece = initialCell.getPiece();
            if (piece == null || piece.isWhite() != currPlayer.isWhite()) {
                System.out.println("No piece at start position or wrong color piece. Try again!!");
                continue;
            }

            if (piece.canMove(board, initialCell, finalCell)) {
                movePiece(board, initialCell, finalCell);
                currPlayer = currPlayer == whitePlayer ? blackPlayer : whitePlayer;
            } else {
                System.out.println("Invalid move. Try again!!");
            }
        }

        System.out.println("Game over. Status: " + gameStatus);
        board.printBoard();

        scanner.close();
    }

    private void movePiece(Board board, Cell initialCell, Cell finalCell) {
        Piece initialCellPiece = initialCell.getPiece();
        Piece finalCellPiece = finalCell.getPiece();

        if (finalCellPiece != null) {
            if (finalCellPiece instanceof King) {
                gameStatus = currPlayer.isWhite() ? GameStatus.WHITE_WIN : GameStatus.BLACK_WIN;
            }
            finalCellPiece.setKilled(true);
        }
        finalCell.setPiece(initialCellPiece);
        initialCell.setPiece(null);
    }
}


