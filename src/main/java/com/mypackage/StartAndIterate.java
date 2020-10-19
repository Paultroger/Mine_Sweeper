package com.mypackage;

import java.awt.*;

public class StartAndIterate {
    // state is whether it is the first game (welcome message) or not.
    private int bombs, hiddenCells, markedCells, boardSize;
    private Point token;
    private boolean firstGame = true;
    private InputOutput myIo;
    private BackEndWithFunctions myBE;
    private TableTop myTT;

    public StartAndIterate() {
        myIo = new InputOutput();
        // myBE = new BackEndWithFunctions();
        myTT = new TableTop();
        // instantiate back end
    }

    public void startGame() {
        System.out.println("Welcome message.");
        // ask for board size;
        // ask for placeBombs;
    }

    public void defuseBomb() {
        myBE.bombExploded(token);
        System.out.println("You lost.");
    }

    public void markCell() {
        myTT.checkForBomb(myBE, token);
        System.out.println(new InputOutput().printBoard(myTT.getTableTop()));
    }
}