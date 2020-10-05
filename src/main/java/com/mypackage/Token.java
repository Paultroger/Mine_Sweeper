package com.mypackage;

import java.util.Scanner;
import static com.mypackage.InputOutput.*;

public class Token {

    TableTop tableTop = new TableTop();
    BackEndWithFunctions backEnd;
    private int bombs, hiddenCells, markedCells;

    // Don't forget to initialize the back end.
    public Token() {
        System.out.println("Welcome to Mind Sweeper!");
        int boardSize = boardSize();
        tableTop.initializeTableTop(boardSize);
    }

    public TableTop getTableTop() {
        return tableTop;
    }
}