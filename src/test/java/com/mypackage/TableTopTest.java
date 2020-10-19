package com.mypackage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;

import java.awt.*;
import java.util.Arrays;
import java.util.Collection;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class TableTopTest {

    private final int boardSize = 8;
    private Point token;
    TableTop myTableTop = new TableTop(8);
    char[][] expectedTableTop;
    BackEndWithFunctions myBE = new BackEndWithFunctions(8, 8) {
        @Override
        public void placeBombs() {
            backEnd = new int[][]{
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 1, 0, 1, 0},
                    {0, 1, 0, 0, 1, 1, 0, 1},
                    {0, 0, 1, 0, 0, 0, 1, 0},
                    {0, 0, 0, 0, 0, 0, 1, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0}
            };
        }
    };

    public TableTopTest(Point coordinates, char[][] tableTopStub) {
        this.token = coordinates;
        this.expectedTableTop = tableTopStub;
    }

    @Parameters
    public static Collection placeToken() {
        return Arrays.asList(new Object[][]{
                {new Point(0, 0), new char[][]{
                        {'B', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}
                }},
                {new Point(5, 1), new char[][]{
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'B', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}
                }},
                {new Point(7, 7), new char[][]{
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'B'}
                }},
                {new Point(4, 5), new char[][]{
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'B', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}
                }}
        });
    }




    @Test
    public void defuseBomb() {
        myTableTop.checkForBomb(myBE, token);
        // System.out.println(new InputOutput().printBoard(myTableTop.getTableTop()));
        // assertArrayEquals(this.expectedTableTop, myTableTop.getTableTop());
    }

    @Test
    public void markCell() {
        myTableTop.markCell(token);
        assertArrayEquals(this.expectedTableTop, myTableTop.getTableTop());
    }

}
