package TicTacToe.Services;

import java.util.Scanner;

import TicTacToe.Enum.GameStatus;
import TicTacToe.Models.Board;
import TicTacToe.Models.Player;

public class Game {

    private final Player player1;
    private final Player player2;
    private final Board board;
    private GameStatus gameStatus;
    private Player currPlayer;

    public Game(Player player1, Player player2, int size) {
        this.player1 = player1;
        this.player2 = player2;
        board = new Board(size);
        this.gameStatus = GameStatus.ONGOING;
        this.currPlayer = player1;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        while (gameStatus == GameStatus.ONGOING) {
            board.printBoard();

            System.out.println(currPlayer.getPlayerName() + "'s turn. Enter row and column (0-" + (board.getSize() - 1) + "):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board.placeMark(row, col, currPlayer.getPlayerMark())) {
                if (board.checkWin(currPlayer.getPlayerMark())) {
                    gameStatus = GameStatus.WON;
                    board.printBoard();
                    System.out.println(currPlayer.getPlayerName() + " wins!!");
                } else if (board.isFull()) {
                    gameStatus = GameStatus.DRAW;
                    board.printBoard();
                    System.out.println("It's a draw!");
                } else {
                    currPlayer = (currPlayer == player1) ? player2 : player1;
                }
            } else {
                System.out.println("Invalid Move!! Try again.");
            }
        }

        scanner.close();
    }

}
