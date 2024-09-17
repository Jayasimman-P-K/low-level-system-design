package SnakeAndLadder.Services;

public class DiceService {
    
    public static int roll(int noOfDices) {
        int total = 0;
        
        for (int i = 0; i < noOfDices; i++) {
            total += Math.ceil(Math.random() * 6);
        }

        return total;
    }
}
