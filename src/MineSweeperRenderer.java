// In this class the main operations, that concern the tableTop layer of the game, are handled.

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MineSweeperRenderer {
/* These are actually Instance variables. They should be integrated into a method at
some point, because they are not needed at Class level. Instances of the game logic
are actually not needed for this program. */


    int[][] backEnd = new int[heigth][heigth];
    int[] marker = new int[2];
    boolean token;

    // a constructor method is not needed for this class.
    public MineSweeperRenderer() {
    }

    // This method is an input method to specify a cell on the field.
    public void readNumber() {
        int[] xrp = new int[2];
        StringBuilder sb = new StringBuilder();
        boolean checkCoordinates = true;
        while (checkCoordinates) {
            System.out.println("Please choose appropriate coordinates. Do mark a cell, add \"M\".");
            sb.setLength(0);
            sb.append((new Scanner(System.in)).next());
            xrp = new int[]{Character.getNumericValue(sb.charAt(0)) , Character.getNumericValue(sb.charAt(1))};
            checkCoordinates = xrp[0] < 1 || xrp[0] > 9 || xrp[1] < 1 || xrp[1] > 9;
        }
        marker[0] = xrp[0]-1;
        marker[1] = xrp[1]-1;
        token = sb.length() >= 3 && sb.charAt(2) == 'M';
    }

    // This method marks a cell in case it contains a bomb.
    public void markExplodedMine() {
       tableTop[marker[0]][marker[1]] = '!';
    }

}





