import static java.lang.System.out;
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    private static char[][] board = new char[3][3];
    private static boolean gameContine = true;
    public static Scanner scan = new Scanner(System.in);
    private static final char EMPTY_CELL = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static char currentPlayer = PLAYER_X;

    public static void main(String[] args) {
        out.println("Welcome to Tic Tac Toe by Danny!");
        initBoard();

        while (gameContine) {
            System.out.println("Current Board:");
            displayBoard();
            System.out.println("Player " + currentPlayer + "'s turn.");

            if (currentPlayer == PLAYER_X) {
                System.out.print("Enter the row (0-2): ");
                int row = scan.nextInt();
                System.out.print("Enter the column (0-2): ");
                int col = scan.nextInt();

                makeMove(row, col);
                // if (makeMove(row, col)) {
                //     board[row][col] = currentPlayer;
                // }
                System.out.println();
            } else {
                Random random = new Random();
                boolean botMove = true;

                while (botMove) {
                int row = random.nextInt(3);
                int col = random.nextInt(3);

                if (makeMove(row, col)) {
                    board[row][col] = currentPlayer;
                    botMove = false;
                }
            }
            System.out.println();

        }

        if (checkWin()) {
            displayBoard();
            System.out.println("The winner is " + currentPlayer);
            gameContine = false;
        }

        if (checkDraw()) {
            displayBoard();
            System.out.println("The game is a draw.");
            gameContine = false;
        }

        switchPlayer();
    }

    }

    private static void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
    }

    private static void displayBoard() {
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("---------");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("---------");
        System.out.println(board[2][0] + " | " + board[1][2] + " | " + board[2][2]);
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }

    private static boolean makeMove(int row, int col) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2 && board[row][col] == EMPTY_CELL) {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    private static boolean moveBot() {
        Random random = new Random();

        while (true) {
            int row = random.nextInt(3);
            int col = random.nextInt(3);

            if (board[row][col] != EMPTY_CELL) {
                board[row][col] = currentPlayer;
                return true;
            }
        }
    }

    public static boolean checkWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != EMPTY_CELL && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != EMPTY_CELL && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] != EMPTY_CELL && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != EMPTY_CELL && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }

        return false;

    }

    public static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY_CELL;
                return false;
            }
        }
        return true;
    }

}