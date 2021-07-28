package com.code.kata.refactoring.intellij.extractRefactoring.extractSupperclass.original;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class AClass {

    public int varInt;
    private double varDouble;
    public static final int CONSTANT = 0;
    public void publicMethod() {
       //do something
    }
    public void hiddenMethod() {
       //do something
    }
    public void setVarDouble(double var) {
        this.varDouble = var;
    }
    public double getVarDouble() {
        return varDouble;
    }

}
