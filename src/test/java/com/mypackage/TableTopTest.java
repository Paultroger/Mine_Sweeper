package com.mypackage;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

public class TableTopTest {

    private final int boardSize = 8;
    TableTop myTableTop = new TableTop(8);
    BackEndWithFunctions mockBE = mock(BackEndWithFunctions.class);
    InputOutput myIO = mock(InputOutput.class);
    private int[] token;

    @Test
    public void defuseBomb() {
        when(mockBE.scan(new int[]{4 , 2})).thenReturn(5);
        when(myIO.placeToken(boardSize)).thenReturn(new int[]{4 , 2});
        token = myIO.placeToken(boardSize);
        // myTableTop.markExplodedCell(token);
        myTableTop.defuseBomb(mockBE, token);
        System.out.println(new InputOutput().printBoard(myTableTop.getTableTop()));
        verify(myIO).placeToken(boardSize);
        verify(mockBE).scan(new int[]{4 , 2});
    }

    public void markCell() {
        myTableTop.markCell(token);
    }

}
