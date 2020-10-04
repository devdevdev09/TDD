package com.tddb.chap02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tddb.chap01.chap02.Calculator;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void plus(){
        int result = Calculator.plus(1,2);
        assertEquals(3,result);
        assertEquals(5, Calculator.plus(4,1));
    }
}
