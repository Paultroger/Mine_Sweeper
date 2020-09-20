package com.mypackage;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MineSweeperBoardTest {

    @Test
    public void validateTableTop() {
        MineSweeperBoard board1 = new MineSweeperBoard(4, 4, 4);
        board1.initializeTableTop();
        assertEquals("\n    1   2   3   4   \n" +
                "1   x   x   x   x   \n" +
                "2   x   x   x   x   \n" +
                "3   x   x   x   x   \n" +
                "4   x   x   x   x   "
                , board1.displayTableTop());
    }

}