package com.code.kata.refactoring.intellij.replaceConditionalWithStrategy.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class InsuranceStrategyMedium extends InsuranceStrategy {
    @Override
    int getConstant() {
        return 35600;
    }

    @Override
    double getWeight() {
        return 0.2;
    }

    @Override
    int getAdjustment() {
        return 10000;
    }
}
