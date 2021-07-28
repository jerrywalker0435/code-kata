package com.code.kata.refactoring.intellij.replaceConditionalWithStrategy.after;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class IfElseDemoTest {
    @Test
    public void low() {
        assertEquals(1825, insuranceFor(5000), 0.01);
    }

    @Test
    public void medium() {
        assertEquals(38600, insuranceFor(25000), 0.01);
    }

    @Test
    public void high() {
        assertEquals(78500, insuranceFor(50000), 0.01);
    }

    @Test
    public void veryHigh() {
        assertEquals(106400, insuranceFor(100_000), 0.01);
    }

    private double insuranceFor(double income) {
        return new IfElseDemo().calculateInsurance(income);
    }
}