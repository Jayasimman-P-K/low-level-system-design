package TicTacToe;

import java.util.Scanner;

import TicTacToe.Models.Player;
import TicTacToe.Services.Game;

class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name of the player1: ");
        String playerName1 = scanner.nextLine();
        System.out.print("Enter name of the player2: ");
        String playerName2 = scanner.nextLine();

        Player player1 = new Player(playerName1, 'X');
        Player player2 = new Player(playerName2, 'O');

        Game  game = new Game(player1, player2, 3);
        game.startGame();

        scanner.close();
    }
}
