package com.code.kata.refactoring.intellij.replaceConditionalWithStrategy.after;

public class InsuranceStrategyVeryHigh extends InsuranceStrategy {
    public InsuranceStrategyVeryHigh() {
    }

    @Override
    int getConstant() {
        return 105600;
    }

    @Override
    double getWeight() {
        return 0.02;
    }

    @Override
    int getAdjustment() {
        return 60000;
    }
}