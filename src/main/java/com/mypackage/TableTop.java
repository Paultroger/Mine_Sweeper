package com.mypackage;

import java.util.Arrays;

/* This class holds the state of the visible part of the game, which is
 * a subset of the backend. It can be amended by the player with some additional,
 * deliberate marks. Those methods are located in the Token class.
 */

public class TableTop {

    private char[][] myTableTop;

    public void initializeTableTop(int x) {
        myTableTop = new char[x][x];
        for (int i = 0; i < x; i++) {
            Arrays.fill(myTableTop[i], 'x');
        }
    }

    public char[][] getTableTop() {
        return myTableTop;
    }

}
