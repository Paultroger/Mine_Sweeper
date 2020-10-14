package com.mypackage;

/* This class keeps the state of the 'back end', being a minimalistic version
 * of a database that holds the positions of the bombs. The methods are
 * designed to return the position and number of the bombs in a certain area
 * of the field.
 */

import java.util.Arrays;
import java.util.Random;

public class BackEndWithFunctions {

    // The variable backEnd is package private to make testing easier.
    int[][] backEnd;
    private int difficulty;
    private int boardSize;

    public BackEndWithFunctions(int boardSize, int difficulty) {
        this.boardSize = boardSize;
        this.difficulty = difficulty;
        backEnd = new int[boardSize][boardSize];
        placeBombs();
    }

    // This method creates the bomb field.
    public void placeBombs() {
        int i = 0;
        while (i < difficulty) {
            Random rand = new Random();
            int y = rand.nextInt(boardSize);
            int x = rand.nextInt(boardSize);
            if (backEnd[y][x] == 0) {
                backEnd[y][x] = 1;
                i++;
            }
        }
    }

    // Checks the cells surrounding a specific cell.
    public int scan(int[] intArray) {
        int y = intArray[0];
        int x = intArray[1];
        int[] array1 = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] array2 = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        int sum = 0;
        for (int i = 0; i < boardSize; i++) {
            int[] z = {y + array1[i], x + array2[i]};
            if (validCell(z))
                sum = sum + returnValue(z);
        }
        return sum - returnValue(intArray);
    }

    // Check, if coordinate is within bounds.
    public boolean validCell(int[] xrp) {
        return (xrp[0] >= 0 && xrp[0] < boardSize && xrp[1] >= 0 && xrp[1] < boardSize);
    }

    // Return the value of a cell.
    private int returnValue(int[] xrp) {
        return backEnd[xrp[0]][xrp[1]];
    }

    // Check, if a cell holds a bomb.
    public boolean bombExploded(int[] intArray) {
        return backEnd[intArray[1]][intArray[1]] != 0;
    }

}