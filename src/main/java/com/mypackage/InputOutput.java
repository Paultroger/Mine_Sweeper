package com.mypackage;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

// This class doesn't need to have state at all.
public class InputOutput {

    // clString stands for command line String.
    public static String clString() {
        return "";
    }

    // clInt stands for command line Integer.
    public static int clInt() {
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

    public static int setMarker(String question) {
        System.out.println(question);
        int drawSticks;
        // return 1;
        return clInt();
    }

    public static void returnTableTop(int sticks) {
        char[] myArray = new char[sticks];
        int i = 5;
        Arrays.fill(myArray, '|');
        StringBuilder sb = new StringBuilder(myArray.length);
        for (Character ch : myArray) {
            sb.append(ch);
        }
        for (int j = 0; j < sticks / 5; j++) {
            sb.insert(i, ' ');
            i = i + 6;
        }
        System.out.print(sb.toString());
        if (sticks > 1)
            System.out.println(" (" + sticks + " sticks left.)");
        else
            System.out.println(" (" + sticks + " stick left.)");
    }

}
