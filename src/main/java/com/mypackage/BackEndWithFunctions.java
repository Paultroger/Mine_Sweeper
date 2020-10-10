package com.mypackage;

/* This class keeps the state of the 'back end', being a minimalistic version
 * of a database that holds the positions of the bombs. The methods are mainly
 * designed to return the position and number of the bombs in a certain area of
 * of the field.
 */

import com.sun.source.tree.BreakTree;

import java.util.Arrays;
import java.util.Random;

public class BackEndWithFunctions {

    private int[][] backEnd;
    private int difficulty;
    private int boardSize;

    public BackEndWithFunctions() {
        this(8, 40);
    }

    public BackEndWithFunctions(int boardSize, int difficulty) {
        backEnd = new int[boardSize][boardSize];
        this.boardSize = boardSize;
        this.difficulty = difficulty;
        for (int i = 0; i < boardSize; i++) {
            Arrays.fill(backEnd[i], 0);
        }
        difficulty();
    }

    public int[][] getBackEnd() {
        return backEnd;
    }

    // This method creates the bomb field.
    public void difficulty() {
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

    /* Finally, these two methods count the bombs
     * in a certain area of the field.
     */
    public int scan(int[] intArray) {
        int y = intArray[0];
        int x = intArray[1];
        int[][] bombRadar = new int[][]{
                {y - 1, x - 1},
                {y - 1, x},
                {y - 1, x + 1},
                {y, x - 1},
                {y, x + 1},
                {y + 1, x - 1},
                {y + 1, x},
                {y + 1, x + 1}
        };
        int sum = 0;
        for (int[] subIntList : bombRadar) {
            if (validCell(subIntList))
                sum = sum + returnValue(subIntList);
        }
        return sum;
    }

    public boolean validCell(int[] xrp) {
        return (xrp[0] >= 0 && xrp[0] < boardSize && xrp[1] >= 0 && xrp[1] < boardSize);
    }

    private int returnValue(int[] xrp) {
        return backEnd[xrp[0]][xrp[1]];
    }

    public boolean bombExploded(int[] intArray) {
        return backEnd[intArray[1]][intArray[1]] != 0;
    }

}