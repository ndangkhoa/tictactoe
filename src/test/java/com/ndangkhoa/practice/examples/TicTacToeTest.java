package com.ndangkhoa.practice.examples;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by ndangkhoa on Mar, 12, 2019
 */
public class TicTacToeTest {
    private TicTacToe ticTacToe;
    private char[][] board;
    
    @Before
    public void setUp() throws Exception {
        ticTacToe = new TicTacToe();
        board = new char[3][3];
    }
    
    @Test
    public void testIsBoardFullShouldReturnTrue(){
        board[0][0] = 'x';
        board[0][1] = 'o';
        board[0][2] = 'x';
    
        board[1][0] = 'o';
        board[1][1] = 'o';
        board[1][2] = 'x';
    
        board[2][0] = 'x';
        board[2][1] = 'x';
        board[2][2] = 'o';
    
        ticTacToe.setBoard(board);
        boolean result = ticTacToe.isBoardFull();
        assertEquals(true, result);
    }
    @Test
    public void testIsBoardFullShouldReturnFalse(){
        board[0][0] = 'x';
        board[0][1] = '-';
        board[0][2] = 'x';
        
        board[1][0] = 'o';
        board[1][1] = 'o';
        board[1][2] = 'x';
        
        board[2][0] = 'x';
        board[2][1] = 'x';
        board[2][2] = 'o';
        
        ticTacToe.setBoard(board);
        boolean result = ticTacToe.isBoardFull();
        assertEquals(false, result);
    }
    
    @Test
    public void testCheckForWinShouldReturnFalse(){
        board[0][0] = 'x';
        board[0][1] = 'o';
        board[0][2] = 'x';
    
        board[1][0] = 'o';
        board[1][1] = 'o';
        board[1][2] = 'x';
    
        board[2][0] = 'x';
        board[2][1] = 'x';
        board[2][2] = 'o';
        
        ticTacToe.setBoard(board);
        boolean result = ticTacToe.checkForWin();
        assertEquals(false, result);
    }
    
    @Test
    public void testCheckForColumnWinShouldReturnTrue(){
        board[0][0] = 'x';
        board[0][1] = 'o';
        board[0][2] = 'x';
        
        board[1][0] = 'o';
        board[1][1] = 'o';
        board[1][2] = 'x';
        
        board[2][0] = 'o';
        board[2][1] = 'x';
        board[2][2] = 'x';
        
        ticTacToe.setBoard(board);
        boolean result = ticTacToe.checkForWin();
        assertEquals(true, result);
    }
    @Test
    public void testCheckForRowWinShouldReturnTrue(){
        board[0][0] = 'x';
        board[0][1] = 'x';
        board[0][2] = 'x';
        
        board[1][0] = 'o';
        board[1][1] = 'o';
        board[1][2] = 'x';
        
        board[2][0] = 'x';
        board[2][1] = 'o';
        board[2][2] = 'o';
        
        ticTacToe.setBoard(board);
        boolean result = ticTacToe.checkForWin();
        assertEquals(true, result);
    }
    
    @Test
    public void testChangePlayerMarkShouldReturnO(){
        char curMark = 'x';
        char newMark = ticTacToe.changePlayerMark(curMark);
        assertEquals('o', newMark);
    }
    
    @Test
    public void testChangePlayerMarkShouldReturnX(){
        char curMark = 'o';
        char newMark = ticTacToe.changePlayerMark(curMark);
        assertEquals('x', newMark);
    }
    
    @Test
    public void testAddMarkShouldReturnTrue(){
        int row = 1, col = 1;
        char[][] board = new char[3][3];
        board[row][col] = '-';
        ticTacToe.setBoard(board);
        
        boolean result = ticTacToe.addMark(row, col);
        assertEquals(true, result);
    }
    
    @Test
    public void testAddMarkShouldReturnFalse(){
        int row = 1, col = 1;
        board[row][col] = 'x';
        ticTacToe.setBoard(board);
        
        boolean result = ticTacToe.addMark(row, col);
        assertEquals(false, result);
    }
}
