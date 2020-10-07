package com.mypackage;

import java.util.Scanner;

public class InputOutput {
    // Finally two methods to help to correctly initialize TableTop and BombLogic.

    public int boardSize() {
        System.out.println("Please chose a value for the size of the bomb-field.");
        return 5; // new Scanner(System.in).nextInt();
    }

    public int difficulty() {
        // ask for difficulty
        return 1;
    }
}
