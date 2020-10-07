package com.mypackage;

import java.util.Scanner;

import static com.mypackage.InputOutput.*;

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