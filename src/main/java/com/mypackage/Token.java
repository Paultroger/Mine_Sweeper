package com.mypackage;

import java.util.Scanner;

import static com.mypackage.InputOutput.*;

/* Classes TableTop and Token could be merged into one at some point.
 * But it also has advantages as they are kept apart. At the current
 * state Table Tops can be passed to methods as parameters easier.
 */
public class Token {

    private int bombs;
    private int hiddenCells;
    private int markedCells;
    private final int boardSize;
    private int[] token = new int[2];
    InputOutput newInputOutput = new InputOutput();

    public Token(int boardSize) {
        newInputOutput = new InputOutput();
        this.boardSize = boardSize;
    }

    public boolean validInput(int y, int x) {
        if (y < 0 | y > boardSize)
            return false;
        else
            token[0] = y;
        if (x < 0 | x > boardSize)
            return false;
        else
            token[1] = x;
        return true;
    }

}