package com.code.kata.refactoring.intellij.replaceConditionalWithStrategy.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class InsuranceStrategyHigh extends InsuranceStrategy {
    @Override
    int getConstant() {
        return 76500;
    }

    @Override
    double getWeight() {
        return 0.1;
    }

    @Override
    int getAdjustment() {
        return 30000;
    }
}
