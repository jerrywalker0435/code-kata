package com.code.kata.refactoring.intellij.replaceConditionalWithStrategy.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public abstract class InsuranceStrategy {
    double calculate(double income) {
        return (income - getAdjustment()) * getWeight() + getConstant();
    }

    abstract int getConstant();

    abstract double getWeight();

    abstract int getAdjustment();
}
