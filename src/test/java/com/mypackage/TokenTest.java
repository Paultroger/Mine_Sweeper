package com.mypackage;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TokenTest {

    TableTop newTableTop;

    @Before
    public void initializeTableTop() {
        newTableTop = new TableTop();
    }

    @Test
    public void validateTableTop() {
        newTableTop.initializeTableTop(5);
        System.out.println(Arrays.deepToString(newTableTop.getTableTop()));
        // assertEquals("\n    1   2   3   4   \n" +
        //         "1   x   x   x   x   \n" +
        //         "2   x   x   x   x   \n" +
        //         "3   x   x   x   x   \n" +
        //         "4   x   x   x   x   "
    }

}