package com.mypackage;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TokenTest {

    TableTop myTableTop = new TableTop(8);
    Token myToken = new Token(8);
    InputOutput myIO = new InputOutput();
    BackEndWithFunctions myBackEnd = new BackEndWithFunctions();

    public void validateTableTop() {
        myIO.navigateToken(myToken);
        char z = myIO.setChar();
        if (z == 'b')
            myTableTop.markCell(myToken.getToken());
        else {
            if (myBackEnd.bombExploded(myToken.getToken())) {
                System.out.println("You lost.");
                myTableTop.markExplodedCell(myToken.getToken());
            }
            else
                myTableTop.defuseBomb(myBackEnd, myToken.getToken());
            System.out.println(new InputOutput().printBoard(myTableTop.getTableTop()));
        }
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
