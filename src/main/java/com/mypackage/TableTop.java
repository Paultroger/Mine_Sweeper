package com.mypackage;

import java.awt.*;
import java.util.Arrays;

/* This class holds the state of the visible part of the game, which is
 * a subset of the backend. It can be amended by the player with some additional,
 * deliberate marks.
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

    public void markCell(Point coordinates) {
        tableTop[coordinates.x][coordinates.y] = 'B';
    }

    public void checkForBomb(BackEndWithFunctions backEnd, Point coordinates) {
        if (backEnd.bombExploded(coordinates))
            tableTop[coordinates.x][coordinates.y] = '!';
        else
            tableTop[coordinates.x][coordinates.y] = (char) (backEnd.scan(coordinates) + '0');
    }

    public char[][] getTableTop() {
        return tableTop;
    }

}
