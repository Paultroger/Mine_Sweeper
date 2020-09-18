/* David try to get accustomed with JUnit tests. The advantage
of using JUnit tests is, that you get customized responses 
for each test case in the form of Exceptions. */

package com.mypackage;

import java.util.Arrays;

public class MineSweeperTestDrive {

    public static void main(String... args) {
        MineSweeperBoard spielfeld = new MineSweeperBoard(5, 5, 5);
        System.out.println(spielfeld.displayTableTop());
        System.out.println(spielfeld.displayBackEnd());
        // Test failed: if game size is smaller than number of bombs then you get caught in an infite loop.
        spielfeld.changeChar(3 , 5 , 'B');
        //System.out.println(spielfeld.displayTableTop());
        //spielfeld.changeChar(4 , 5 , 'i');
        //System.out.println(spielfeld.displayTableTop());
    }
}