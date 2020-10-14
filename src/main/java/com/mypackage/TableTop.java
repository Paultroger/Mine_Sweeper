package com.mypackage;

import java.util.Arrays;

/* This class holds the state of the visible part of the game, which is
 * a subset of the backend. It can be amended by the player with some additional,
 * deliberate marks. Those methods are located in the Token class.
 */

public class TableTop {

    private final char[][] tableTop;

    public TableTop() {
        this(8);
    }

    public TableTop(int boardSize) {
        tableTop = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            Arrays.fill(tableTop[i], 'x');
        }
    }

    public void markCell(int[] intArray) {
        tableTop[intArray[0]][intArray[1]] = 'B';
    }

    public void defuseBomb(BackEndWithFunctions backEnd, int[] intArray) {
        tableTop[intArray[0]][intArray[1]] = (char) (backEnd.scan(intArray) + '0');
    }

    public char[][] getTableTop() {
        return tableTop;
    }

    public void markExplodedCell(int[] intArray) {
        tableTop[intArray[0]][intArray[1]] = '!';
    }

}
