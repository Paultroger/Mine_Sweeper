package com.mypackage;

import java.util.Arrays;

/* This class holds the state of the visible part of the game, which is
 * a subset of the backend. It can be amended by the player with some additional,
 * deliberate marks. Those methods are located in the Token class.
 */

public class TableTop {

    private char[][] myTableTop;

    public TableTop() {
        this(9);
    }

    public TableTop(int boardSize) {
        myTableTop = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            Arrays.fill(myTableTop[i], 'x');
        }
    }

    public void markCell(int[] intArray) {
        myTableTop[intArray[0]][intArray[1]] = 'B';
    }

    public char[][] getTableTop() {
        return myTableTop;
    }

}
