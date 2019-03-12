package com.ndangkhoa.practice.examples;

/**
 * Created by ndangkhoa on Mar, 12, 2019
 */
public class TicTacToe {
    
    private char[][] board;
    private char currentPlayerMark;
    public TicTacToe() {
        board = new char[3][3];
        currentPlayerMark = 'x';
    }
    
    public void setBoard(char[][] board) {
        this.board = board;
    }
    
    public char getCurrentPlayerMark()
    {
        return currentPlayerMark;
    }
    
    public void setCurrentPlayerMark(char currentPlayerMark) {
        this.currentPlayerMark = currentPlayerMark;
    }
    
    /**
     * Initialize the board, the empty cell will store '-'
     */
    public void initBoard() {
        
        // Each row
        for (int i = 0; i < 3; i++) {
            
            // Each column
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    
    /**
     * Print out the board
     */
    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }
    
    
    /**
     * Loop through all cells of the board
     * @return false if has '-' in the board, otherwise return true
     */
    public boolean isBoardFull() {
        boolean isFull = true;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                }
            }
        }
        
        return isFull;
    }
    
    /**
     * This calls our other win check functions to check the entire board.
     * @return true if there is a win, false otherwise.
     */
    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }
    
    
    /**
     * Loop through rows and see if any are winners.
     * @return
     */
    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * Loop through columns and see if any are winners.
     * @return
     */
    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * Check the two diagonals
     * @return
     */
    private boolean checkDiagonalsForWin() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true)
                || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
    }
    
    
    /**
     * Check row and column
     * @param c1
     * @param c2
     * @param c3
     * @return  true when all values are the same and not empty, otherwise return false
     */
    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }
    
    /**
     * change the player mark back
     * @param currentMark
     * @return letter o when currentMark is x otherwise letter x
     */
    public char changePlayerMark(char currentMark) {
        if (currentMark == 'x') {
            return 'o';
        }
        else {
            return 'x';
        }
    }
    
    /**
     * Place a mart of current player at the cell specified by row and column
     * @param row
     * @param col
     * @return true when added, otherwise return false
     */
    public boolean addMark(int row, int col) {
        if ((row < 3) && (row >= 0)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == '-') {
                    board[row][col] = currentPlayerMark;
                    return true;
                }
            }
        }
        return false;
    }
}
