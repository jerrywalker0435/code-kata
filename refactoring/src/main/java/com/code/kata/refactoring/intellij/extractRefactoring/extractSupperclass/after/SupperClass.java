package com.code.kata.refactoring.intellij.extractRefactoring.extractSupperclass.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class SupperClass {
    public static final int CONSTANT = 0;
    private double varDouble;

    public void publicMethod() {
       //do something
    }

    public void setVarDouble(double var) {
        this.varDouble = var;
    }

    public double getVarDouble() {
        return varDouble;
    }
}
