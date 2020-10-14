package com.mypackage;

import java.util.Scanner;

public class InputOutput {

    Scanner sc = new Scanner(System.in);

    public int[] placeToken(int boardSize) {
        System.out.println("Where would you like to place your token?");
        int x = askForInt('X');
        int y = askForInt('Y');
        while (x >= boardSize || y >= boardSize) {
            System.out.print("Your coordinate(s) is/are out of bound. ");
            x = askForInt('X');
            y = askForInt('Y');
        }
        return new int[]{y, x};
    }

    private int askForInt(char coordinate) {
        System.out.print("Coordinate " + coordinate + ": ");
        while (true) {
            int placeHolder = sc.nextInt() - 1;
            if (positiveInt(placeHolder, coordinate))
                return placeHolder;
        }
    }

    private boolean positiveInt(int integer, char coordinate) {
        if (integer < 0) {
            System.out.print("You chose a negative number or zero. "
                    + "Please try again.\nCoordinate " + coordinate + ": ");
            return false;
        }
        return true;
    }

    public char setChar() {
        System.out.println("Action (B for mark bomb, X for defuse) : ");
        return Character.toLowerCase(sc.next().charAt(0));
    }

    public int boardSize() {
        System.out.println("Please chose a value for the size of the bomb-field.");
        return 5; // new Scanner(System.in).nextInt();
    }

    public int difficulty() {
        // ask for placeBombs
        return 1;
    }

    public boolean resumeGame() {
        System.out.println("Would you like to play another round?");
        return true;
    }

    public String printBoard(char[][] board) {
        StringBuilder sb = new StringBuilder().append("    ");
        StringBuilder sb2 = new StringBuilder();
        String text = "";
        for (int i = 0; i < board.length; i++) {
            sb.append(i + 1).append("   ");
        }
        sb.append("\n");
        for (int j = 0; j < board.length; j++) {
            sb.append(j + 1).append("   ");
            // If the number has two digits, one space character is removed.
            if (j > 8)
                sb.delete(3, 4);
            for (char value : board[j]) {
                sb.append(value).append("   ");
            }
            sb2.append("\n").append(sb);
            sb.setLength(0);
        }
        return sb2.toString();
    }
}
