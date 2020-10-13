package com.mypackage;

public class GameState {
    // state is whether it is the first game (welcome message) or not.
    boolean firstGame = true;
    InputOutput myIo;
    TableTop myTT;
    Token myToken;
    int bombs;
    int hiddenCells;
    int markedCells;

    public GameState() {
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
