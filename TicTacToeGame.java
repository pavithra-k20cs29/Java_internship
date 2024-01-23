package Java_Internship;

import java.util.Scanner;

public class TicTacToeGame {
    private char[][] board;
    private char currentPlayer;
    private int moves;
    
    public TicTacToeGame() {
        board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        currentPlayer = 'X';
        moves = 0;
    }

    public void startGame() {
        boolean playAgain = true;

        while (playAgain) {
            initBoard();
            boolean gameFinished = false;

            while (!gameFinished) {
                displayBoard();
                makeMove();
                if (checkWin()) {
                    displayBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameFinished = true;
                } else if (checkDraw()) {
                    displayBoard();
                    System.out.println("It's a draw!");
                    gameFinished = true;
                } else {
                    switchPlayer();
                }
            }

            playAgain = askToPlayAgain();
        }
    }

    private void initBoard() {
        board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        currentPlayer = 'X';
        moves = 0;
    }

    private void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    private void makeMove() {
        Scanner scanner = new Scanner(System.in);
        boolean validMove = false;

        while (!validMove) {
            System.out.print("Player " + currentPlayer + " enter your move (1-9): ");
            int move = scanner.nextInt();
            int row = (move - 1) / 3;
            int col = (move - 1) % 3;

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                validMove = true;
                moves++;
            } else {
                System.out.println("Invalid move! Please try again.");
            }
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            // Check columns
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }

    private boolean checkDraw() {
        return moves == 9;
    }

    private void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    private boolean askToPlayAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Play again? (y/n): ");
        String playAgain = scanner.nextLine();
        return playAgain.equalsIgnoreCase("y");
    }

    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        ticTacToeGame.startGame();
    }
}