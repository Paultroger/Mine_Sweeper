// Test failed: if game size is smaller than number of bombs then you get caught in an infite loop.

import java.util.Arrays;

public class MineSweeperTestDrive {

    public static void main(String... args) {
        MineSweeperUserBoard spielfeld = new MineSweeperUserBoard(5, 5, 5);
        System.out.println(spielfeld.displayTableTop());
        System.out.println(spielfeld.displayBackEnd());
        //spielfeld.changeChar(3 , 5 , 'B');
        //System.out.println(spielfeld.displayTableTop());
        //spielfeld.changeChar(4 , 5 , 'i');
        //System.out.println(spielfeld.displayTableTop());
    }
}