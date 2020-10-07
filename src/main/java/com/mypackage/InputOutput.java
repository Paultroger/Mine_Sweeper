package com.mypackage;

import java.util.Scanner;

public class InputOutput {

    public int[] placeToken(Token token) {
        System.out.println("Where would you like to place your token?");
        if (token.validInput(5 , 5))
            return new int[]{5 , 5}; // new Scanner(System.in).nextInt();
        else
            return new int[]{0 , 0};
    }

    public int boardSize() {
        System.out.println("Please chose a value for the size of the bomb-field.");
        return 5; // new Scanner(System.in).nextInt();
    }

    public int difficulty() {
        // ask for difficulty
        return 1;
    }

    public boolean resumeGame() {
        System.out.println("Would you like to play another round?");
        return true;
    }

    public static String printBoard(char[][] board) {
        StringBuilder sb = new StringBuilder().append("    ");
        StringBuilder sb2 = new StringBuilder();
        String text = "";
        for (int i = 0; i < board.length; i++) {
            sb.append(i+1).append("   ");
        }
        sb.append("\n");
        for (int j = 0; j < board.length; j ++) {
            sb.append(j+1).append("   ");
            // If the number has two digits, one space character is removed.
            if (j > 8)
                sb.delete(3 , 4);
            for (char value : board[j]) {
                sb.append(value).append("   ");
            }
            sb2.append("\n").append(sb);
            sb.setLength(0);
        }
        return sb2.toString();
    }
}
