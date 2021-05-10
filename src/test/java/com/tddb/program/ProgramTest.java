package com.tddb.program;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class ProgramTest {

    @Test
    void 숫자의_좌표_구하기(){
        Program program = new Program();
        int[] expect = new int[2];
        expect = new int[]{1,1};

        int[] pos1 = program.getPos("1");
        assertArrayEquals(expect, pos1);

        int[] pos2 = program.getPos("2");

        expect = new int[]{1,2};
        assertArrayEquals(expect, pos2);

        int[] pos3 = program.getPos("3");

        expect = new int[]{1,3};
        assertArrayEquals(expect, pos3);


        int[] posA = program.getPos("#");

        expect = new int[]{4,1};
        assertArrayEquals(expect, posA);

        int[] posB = program.getPos("*");

        expect = new int[]{4,3};
        assertArrayEquals(expect, posB);
    }

    @Test
    void 두_숫자의_거리_구하기(){
        Program program = new Program();

        int num1 = program.getDistance("1","2");
        assertEquals(num1, 1);

        int num2 = program.getDistance("3","2");
        assertEquals(num2, 1);

        int num3 = program.getDistance("4","2");
        assertEquals(num3, 2);

        int num4 = program.getDistance("6","2");
        assertEquals(num4, 2);

        int num5 = program.getDistance("7","2");
        assertEquals(num5, 3);

        int num6 = program.getDistance("9","2");
        assertEquals(num6, 3);

    }
}

