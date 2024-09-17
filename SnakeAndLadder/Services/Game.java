package SnakeAndLadder.Services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import SnakeAndLadder.Models.Board;
import SnakeAndLadder.Models.Ladder;
import SnakeAndLadder.Models.Player;
import SnakeAndLadder.Models.Snake;

public class Game {
    private Board board;
    private int noOfDices;
    private Queue<Player> players;

    public Game(int boardSize, int noOfDices) {
        this.board = new Board(boardSize);
        this.noOfDices = noOfDices;
        this.players = new LinkedList<Player>();
    }

    // ============= Initializing the board ====================

    public void setPlayers(List<Player> players) {
        this.players = new LinkedList<Player>();
        Map<String, Integer> playerPieces = new HashMap<String, Integer>();
        for (Player player: players) {
            this.players.add(player);
            playerPieces.put(player.getPlayerId(), 0);
        }
        board.setPlayerPieces(playerPieces);
    }

    public void setSnakes(List<Snake> snakes) {
        board.setSnakes(snakes);
    }

    public void setLadders(List<Ladder> ladders) {
        board.setLadders(ladders);
    }

    // ================= Game Logic ======================

    // logic for rolling N number of dice
    public int getValueAfterDiceRolls() {
        return DiceService.roll(noOfDices);
    }

    public boolean hasPlayerWon(Player player) {
        int playerPosition = board.getPlayerPieces().get(player.getPlayerId());
        int boardSize = board.getBoardSize();
        return playerPosition == boardSize;
    }

    public boolean isGameCompleted() {
        return players.size() == 1;
    }

    public void startGame() {
        while (!isGameCompleted()) {
            int diceRollValue = getValueAfterDiceRolls();
            Player currPlayer = players.poll();
            movePLayer(currPlayer, diceRollValue);
            int raceCount = 1;
            if (hasPlayerWon(currPlayer)) {
                System.out.println(currPlayer.getPlayerName() + " has completed the race and placed NO: " + raceCount++);
                board.getPlayerPieces().remove(currPlayer.getPlayerId());
            } else {
                players.add(currPlayer);
            }
        }
    }

    public void movePLayer(Player player, int positions) {
        int oldPosition = board.getPlayerPieces().get(player.getPlayerId());
        int newPosition = oldPosition + positions;

        if (newPosition > board.getBoardSize()) {
            newPosition = oldPosition;
        } else {
            newPosition = getNewPositionAfterGoingThroughSnakeAndLadder(newPosition);
        }

        board.getPlayerPieces().put(player.getPlayerId(), newPosition);
        System.out.println(player.getPlayerName() + " rolled a " + positions + " and moved from " + oldPosition + " to " + newPosition);
    }

    public int getNewPositionAfterGoingThroughSnakeAndLadder(int newPosition) {
        int previousPosition;

        do {
            previousPosition = newPosition;
            for (Snake snake : board.getSnakes()) {
                if (snake.getStart() == newPosition) {
                    newPosition = snake.getEnd();
                }
            }
            for (Ladder ladder : board.getLadders()) {
                if (ladder.getStart() == newPosition) {
                    newPosition = ladder.getEnd();
                }
            }
        } while (previousPosition != newPosition);

        return newPosition;
    }
}