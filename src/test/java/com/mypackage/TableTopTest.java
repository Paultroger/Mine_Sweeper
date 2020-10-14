package com.mypackage;

import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

public class TableTopTest {

    private final int boardSize = 8;
    private int[] token;
    TableTop myTableTop = new TableTop(8);
    InputOutput myIO = mock(InputOutput.class);
    BackEndWithFunctions myBE = new BackEndWithFunctions(8, 8) {

        @Override
        public void placeBombs() {
            backEnd = new int[][]{
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 1, 0, 0, 0},
                    {0, 1, 0, 0, 1, 0, 0, 0},
                    {0, 0, 1, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0}
            };
        }
    };

        @Test
        public void defuseBomb() {
            when(myIO.placeToken(boardSize)).thenReturn(new int[]{5, 0});
            token = myIO.placeToken(boardSize);
            myTableTop.defuseBomb(myBE, token);
            System.out.println(new InputOutput().printBoard(myTableTop.getTableTop()));
            verify(myIO).placeToken(boardSize);
        }

        public void markCell() {
            myTableTop.markCell(token);
        }

    }
