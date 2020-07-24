// This is the Main class of the program MineSweeper.

package com.paultroger;

import java.util.Scanner;public class MineSweeper {

    public static void main(String... args) {
        boolean newGame = true;
        while (newGame) {
            game();
            System.out.println("Do you want to play again? (Y/N)");
            newGame = resumeGame();
        }
    }

    public static void game() {
        MineSweeper2 spielfeld = new MineSweeper2();
        spielfeld.placeBomb();
        round(spielfeld);
    }


    public static void round(MineSweeper2 spielfeld1) {
        boolean bombExploded = false;
        while (!bombExploded) {
            if (spielfeld1.gameOver()){
                System.out.println("Congratulations, you did it!!");
                break;
            }

            spielfeld1.readNumber();
            if (spielfeld1.token) {
                spielfeld1.setMarker(spielfeld1.marker);
//                spielfeld1.displayBackEnd();
                System.out.println("");
                spielfeld1.displayTableTop();
            }
            else {
                spielfeld1.inspectCell(spielfeld1.marker);
                bombExploded = defuseBomb(spielfeld1);
//                spielfeld1.displayBackEnd();
                System.out.println("");
                spielfeld1.displayTableTop();
            }
        }
    }

    public static boolean defuseBomb(MineSweeper2 spielfeld1) {
        if (spielfeld1.backEnd[spielfeld1.marker[0]][spielfeld1.marker[1]] == 1) {
            System.out.println("BUMM! You're dead!");
            return true;
        }
        else
            return false;
    }

    public static boolean resumeGame() {
            String simonSays = "";
            while (!simonSays.equals("y") && !simonSays.equals("n")) {
                System.out.println("Please enter \"Y\" or \"N\"");
                simonSays = new Scanner(System.in).nextLine().toLowerCase();
            }
            return simonSays.equals("y");
        }
}
