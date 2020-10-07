package com.mypackage;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TokenTest {

    Token myToken = new Token();

    @Test
    public void validateTableTop() {
        // System.out.println(Arrays.deepToString(myToken.getTableTop().getTableTop()));
        // assertEquals("\n    1   2   3   4   \n" +
        //         "1   x   x   x   x   \n" +
        //         "2   x   x   x   x   \n" +
        //         "3   x   x   x   x   \n" +
        //         "4   x   x   x   x   "
    }

}