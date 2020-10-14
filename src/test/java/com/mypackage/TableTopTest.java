package com.mypackage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class TableTopTest {

    private final int boardSize = 8;
    private int[] token;
    TableTop myTableTop = new TableTop(8);
    InputOutput myIO = mock(InputOutput.class);
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

    public TableTopTest(int[] coordinates, char[][] backEndStub) {
        this.token = coordinates;
        this.expectedTableTop = backEndStub;

    }

    @Parameters
    public static Collection placeToken() {
        return Arrays.asList(new Object[][]{
                {new int[]{0, 0}, new char[][]{
                        {'0', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}
                }},
                {new int[]{5, 1}, new char[][]{
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', '2', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}
                }},
                {new int[]{7, 7}, new char[][]{
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', '2'}
                }},
                {new int[]{4, 5}, new char[][]{
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x', '!', 'x', 'x'},
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
        assertArrayEquals(this.expectedTableTop, myTableTop.getTableTop());
    }

    public void markCell() {
        myTableTop.markCell(token);
    }

}
