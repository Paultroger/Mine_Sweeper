package com.mypackage;

/* This class keeps the state of the 'back end', being a minimalistic version
 * of a database that holds the positions of the bombs. The methods are
 * designed to return the position and number of the bombs in a certain area
 * of the field.
 */

import java.awt.*;
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
    public int scan(Point coordinates) {
        int x = coordinates.x;
        int y = coordinates.y;
        int[] array1 = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] array2 = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        int sum = 0;
        for (int i = 0; i < boardSize; i++) {
            Point z = new Point(x + array1[i], y + array2[i]);
            if (validCell(z))
                sum = sum + returnValue(z);
        }
        return sum - returnValue(coordinates);
    }

    // Check, if coordinate is within bounds.
    public boolean validCell(Point coordinates) {
        return (coordinates.x >= 0 && coordinates.x < boardSize && coordinates.y >= 0 && coordinates.y < boardSize);
    }

    // Return the value of a cell.
    private int returnValue(Point coordinates) {
        return backEnd[coordinates.x][coordinates.y];
    }

    // Check, if a cell holds a bomb.
    public boolean bombExploded(Point coordinates) {
        return backEnd[coordinates.x][coordinates.y] != 0;
    }

}