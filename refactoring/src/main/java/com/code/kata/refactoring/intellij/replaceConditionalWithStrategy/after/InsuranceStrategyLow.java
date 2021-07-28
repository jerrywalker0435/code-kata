package com.code.kata.refactoring.intellij.replaceConditionalWithStrategy.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class InsuranceStrategyLow extends InsuranceStrategy {
    @Override
    int getConstant() {
        return 0;
    }

    @Override
    double getWeight() {
        return 0.365;
    }

    @Override
    int getAdjustment() {
        return 0;
    }
}
