package com.ndangkhoa.practice.examples;

import java.util.Scanner;

/**
 * Created by ndangkhoa on Mar, 12, 2019
 */
public class AppMain {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        game.initBoard();
        
        do {
            System.out.println("New board: ");
            game.printBoard();
            int row, col;
            do {
                System.out.println("Player " + Character.toUpperCase(game.getCurrentPlayerMark()) +
                        ", please enter an empty row then enter an empty column");
                row = scan.nextInt() - 1;
                col = scan.nextInt() - 1;
            }
            while (!game.addMark(row, col));{
                char curMark = game.getCurrentPlayerMark();
                char newMark = game.changePlayerMark(curMark);
                game.setCurrentPlayerMark(newMark);
            }
        } while (!game.checkForWin() && !game.isBoardFull());
        
        if (game.isBoardFull() && !game.checkForWin()) {
            System.out.println("Game ended!");
        } else {
            game.printBoard();
            char curMark = game.getCurrentPlayerMark();
            char newMark = game.changePlayerMark(curMark);
            game.setCurrentPlayerMark(newMark);
            System.out.println("The winner: " + Character.toString(game.getCurrentPlayerMark()).toUpperCase());
        }
        
    }
}
