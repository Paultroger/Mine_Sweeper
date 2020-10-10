package com.mypackage;

import java.util.Scanner;

import static com.mypackage.InputOutput.*;

public class Token {

    private int bombs;
    private int hiddenCells;
    private int markedCells;
    private final int boardSize;


    private int[] token = new int[2];
    private char character;
    InputOutput newInputOutput = new InputOutput();

    public Token(int boardSize) {
        newInputOutput = new InputOutput();
        this.boardSize = boardSize;
    }

    public boolean validToken(int placeHolder) {
        return placeHolder < boardSize;
    }

    public void setToken(int[] token) throws IndexOutOfBoundsException {
        if (token[0] < boardSize && token[1] < boardSize)
            this.token = token;
        else
            throw new IndexOutOfBoundsException();
    }

    public int[] getToken() {
        return token;
    }

}