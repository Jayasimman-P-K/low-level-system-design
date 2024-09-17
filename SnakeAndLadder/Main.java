package SnakeAndLadder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import SnakeAndLadder.Models.Ladder;
import SnakeAndLadder.Models.Player;
import SnakeAndLadder.Models.Snake;
import SnakeAndLadder.Services.Game;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);    
        
        System.out.print("Enter the no of snakes to be placed in the game: ");
        int noOfSnakes = in.nextInt();
        List<Snake> snakes = new ArrayList<>();
        for (int i = 1; i <= noOfSnakes; i++) {
            System.out.print("Enter the starting position and the ending position of the snake number " + i + " : ");
            snakes.add(new Snake(in.nextInt(), in.nextInt()));
        }

        System.out.print("Enter the no of ladders to be placed in the game: ");
        int noOfLadders = in.nextInt();
        List<Ladder> ladders = new ArrayList<>();
        for (int i = 1; i <= noOfLadders; i++) {
            System.out.print("Enter the starting position and the ending position of the ladder number " + i + " : ");
            ladders.add(new Ladder(in.nextInt(), in.nextInt()));
        }

        System.out.print("Enter the no of players in the game: ");
        int noOfPlayers = in.nextInt();
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= noOfPlayers; i++) {
            System.out.println("Enter the player name of the number " + i + " : ");
            players.add(new Player(in.next()));
        }

        Game game = new Game(100, 1);
        game.setPlayers(players);
        game.setLadders(ladders);
        game.setSnakes(snakes);

        game.startGame();

        in.close();
    }
}
