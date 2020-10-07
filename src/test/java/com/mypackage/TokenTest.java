package com.mypackage;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStreamReader;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TokenTest {

    TableTop myTableTop = new TableTop(8);
    Token myToken = new Token(8);

    @Test
    public void validateTableTop() {
        new InputOutput().placeToken(myToken);
        System.out.println(new InputOutput().printBoard(myTableTop.getTableTop()));
    }
}

        // assertEquals("\n    1   2   3   4   \n" +
        //         "1   x   x   x   x   \n" +
        //         "2   x   x   x   x   \n" +
        //         "3   x   x   x   x   \n" +
        //         "4   x   x   x   x   "
