// In this class the main operations, that concern the tableTop layer of the game, are handled.

package com.paultroger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;
import java.util.stream.IntStream;

public class MineSweeper2 {
    int[][] backEnd = new int[9][9];
    char[][] tableTop = new char[][] {
        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}
    };
    int[] marker = new int[2];
    boolean token;

    public MineSweeper2() {
    }

//  Initializes the BackEnd with a sufficient number of bombs.
    public void placeBomb() {
        while (countBomb() < 20) {
            Random rand = new Random();
            int y = rand.nextInt(9);
            int x = rand.nextInt(9);
            backEnd[y][x] = 1;
        }
    }

    public int countBomb() {
        ArrayList<Integer> alist = new ArrayList<Integer>();
        for (int[] testArray : backEnd) {
            alist.add(IntStream.of(testArray).sum());
        }
        int x = alist.stream().mapToInt(Integer::intValue).sum();
        return x;
    }

    public boolean gameOver() {
        int cells = 0;
        for (char[] testArray : tableTop) {
            for (char testChar : testArray) {
                if (testChar == 'x')
                    cells++;
            }
        }
    return cells == 0;
    }

    public void displayTableTop() {
        StringBuilder sb = new StringBuilder();
        sb.append("   1   2   3   4   5   6   7   8   9\n");
        for (int i = 0; i < 9; i ++) {
            sb.append(i+1).append("  ");
            for (char value : tableTop[i]) {
                sb.append(value).append("   ");
            }
                String text = sb.toString();
                System.out.println(text);
                sb.setLength(0);
        }
    }

    public void displayBackEnd() {
        StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i ++) {
                sb.append("   ");
                for (int value : backEnd[i]) {
                sb.append(value).append("   ");
            }
                String text = sb.toString();
                System.out.println(text);
                sb.setLength(0);
        }
    }

    public void readNumber() {
        int[] xrp = new int[2];
        StringBuilder sb = new StringBuilder();
        boolean checkCoordinates = true;

        while (checkCoordinates) {
            System.out.println("Please choose appropriate coordinates. Do mark a cell, add \"M\".");
            sb.setLength(0);
            sb.append((new Scanner(System.in)).next());
            sb.append("    ");
            xrp = new int[]{Character.getNumericValue(sb.charAt(0)) , Character.getNumericValue(sb.charAt(1))};
            checkCoordinates = xrp[0] < 1 || xrp[0] > 9 || xrp[1] < 1 || xrp[1] > 9;
            }
        marker[0] = xrp[0]-1;
        marker[1] = xrp[1]-1;
        token = new Character(sb.charAt(2)).equals('M');
    }

    public void setMarker(int[] xrp) {
        if (new Character(tableTop[xrp[0]][xrp[1]]).equals('B'))
            tableTop[xrp[0]][xrp[1]] = 'x';
        else
            tableTop[xrp[0]][xrp[1]] = 'B';
    }

    public void inspectCell(int[] xrp) {
        tableTop[xrp[0]][xrp[1]] = (char)(scan() + '0');
        }

    public int scan() {
        ArrayList<Integer> alist = new ArrayList<Integer>();
        int y = marker[0];
        int x = marker[1];
        int[][] bombRadar = new int[][]{
            { y-1 , x-1 },
            { y-1 , x },
            { y-1 , x+1 },
            { y , x-1 },
            { y , x+1 },
            { y+1 , x-1 },
            { y+1 , x },
            { y+1 , x+1 },
        };

        for (int[] testArray : bombRadar) {
            alist.add(count(testArray));
        }
        int sum = alist.stream().mapToInt(Integer::intValue).sum();
        return sum;
    }

    public int count(int[] xrp) {
        if (xrp[0] < 0 || xrp[0] > 8 || xrp[1] < 0 || xrp[1] > 8)
            return 0;
        else {
            return backEnd[xrp[0]][xrp[1]];
        }
    }
}





