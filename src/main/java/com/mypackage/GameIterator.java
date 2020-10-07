package com.mypackage;

public class GameIterator {
    // state is whether it is the first game (welcome message) or not.
    boolean firstGame = true;
    InputOutput myIo;
    TableTop myTT;
    Token myToken;

    public GameIterator() {
        myIo = new InputOutput();
        myTT= new TableTop();
        myToken = new Token(9);
        // instantiate back end
    }

    public void startGame() {
        System.out.println("Welcome message.");
        // ask for board size;
        // ask for difficulty;
    }

    public void gameRound() {
    }

}
