package com.mypackage;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStreamReader;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TokenTest {

    TableTop myTableTop = new TableTop(8);
    Token myToken = new Token(8);
    InputOutput myIO = new InputOutput();

    public void validateTableTop() {
        myIO.placeToken(myToken);
        myTableTop.markCell(myToken.getToken());
        System.out.println(new InputOutput().printBoard(myTableTop.getTableTop()));
    }

    public static void main(String... kong) {
        TokenTest tt = new TokenTest();
        tt.validateTableTop();
    }
}

        // assertEquals("\n    1   2   3   4   \n" +
        //         "1   x   x   x   x   \n" +
        //         "2   x   x   x   x   \n" +
        //         "3   x   x   x   x   \n" +
        //         "4   x   x   x   x   "
