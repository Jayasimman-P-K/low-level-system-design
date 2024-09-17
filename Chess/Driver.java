package Chess;

import java.util.Scanner;

import Chess.Services.ChessGame;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name of white player: ");
        String whitePlayerName = scanner.nextLine();

        System.out.print("Enter name of black player: ");
        String blackPlayerName = scanner.nextLine();

        ChessGame chessGame = new ChessGame(whitePlayerName, blackPlayerName);
        chessGame.startGame();

        scanner.close();
    }
}
