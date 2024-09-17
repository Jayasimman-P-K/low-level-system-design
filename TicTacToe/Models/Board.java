package TicTacToe.Models;

public class Board {

    private final char[][] board;
    private final int size;


    public Board(int size) {
        this.size = size;
        board = new char[size][size];
        inititalizeBoard(size);
    }

    private void inititalizeBoard(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public boolean placeMark(int row, int col, char mark) {
        if (row >= 0 && row < size && col >= 0 && col < size && board[row][col] == '-') {
            board[row][col] = mark;
            return true;
        }

        return false;
    }

    public boolean checkWin(char mark) {
        for (int i = 0; i < size; i++) {
            if (checkRow(i, mark) || checkCol(i, mark)) {
                return true;
            }
        }
        return checkDiagonal(mark);
    }

    public boolean checkRow(int row, char mark) {
        for (int i = 0; i < size; i++) {
            if (board[row][i] != mark) {
                return false;
            }
        }
        return true;
    }

    public boolean checkCol(int col, char mark) {
        for (int i = 0; i < size; i++) {
            if (board[i][col] != mark) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagonal(char mark) {
        boolean diagonal1 = true, diagonal2 = true;

        for (int i = 0; i < size; i++) {
            if (board[i][i] != mark) diagonal1 = false;
            if (board[i][size - i - 1] != mark) diagonal2 = false;
        }

        return diagonal1 || diagonal2;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }

    public int getSize() {
        return size;
    }
}
