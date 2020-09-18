package com.mypackage;

public class MineSweeperGame {

    public static void main(String... args) {
        boolean newGame = true;
        while (newGame) {
            game();
            System.out.println("Do you want to play again? (Y/N)");
            newGame = resumeGame();
        }
    }

    public static boolean resumeGame() {
            String simonSays = "";
            while (!simonSays.equals("y") && !simonSays.equals("n")) {
                System.out.println("Please enter \"Y\" or \"N\"");
                simonSays = new Scanner(System.in).nextLine().toLowerCase();
            }
            return simonSays.equals("y");
        }
    
    public static void game() {
        MineSweeperRenderer spielfeld = new MineSweeperRenderer();
        spielfeld.initializeTableTop();
        spielfeld.placeBomb();
        round(spielfeld);
    }

/*  This method prompts the user for an action, i.e. marking
or inspecting a cell, and executes the action. */
    public static void round(MineSweeperRenderer spielfeld1) {
        boolean bombExploded = false;
        while (!bombExploded) {
            if (spielfeld1.gameOver()){
                System.out.println("Congratulations, you did it!!");
                break;
            }

            spielfeld1.readNumber();
            if (spielfeld1.token) {
                spielfeld1.setMarker(spielfeld1.marker);
                spielfeld1.displayBackEnd();
                System.out.println("");
                spielfeld1.displayTableTop();
            }
            else {
                spielfeld1.inspectCell(spielfeld1.marker);
                bombExploded = defuseBomb(spielfeld1);
                spielfeld1.displayBackEnd();
                System.out.println("");
                spielfeld1.displayTableTop();
            }
        }
    
    public static boolean defuseBomb(MineSweeperRenderer spielfeld1) {
        if (spielfeld1.backEnd[spielfeld1.marker[0]][spielfeld1.marker[1]] == 1) {
            System.out.println("BUMM! You're dead!");
            spielfeld1.markExplodedMine();
            return true;
        }
        else
            return false;
    }
}