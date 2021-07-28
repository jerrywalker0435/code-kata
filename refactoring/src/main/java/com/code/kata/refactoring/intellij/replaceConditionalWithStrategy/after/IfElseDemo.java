package com.code.kata.refactoring.intellij.replaceConditionalWithStrategy.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class IfElseDemo {
    private InsuranceStrategy strategy;

    public double calculateInsurance(double income) {
        if (income <= 10000) {
            strategy = new InsuranceStrategyLow();
            return strategy.calculate(income);
        } else if (income <= 30000) {
            strategy = new InsuranceStrategyMedium();
            return strategy.calculate(income);
        } else if (income <= 60000) {
            strategy = new InsuranceStrategyHigh();
            return strategy.calculate(income);
        } else {
            strategy = new InsuranceStrategyVeryHigh();
            return strategy.calculate(income);
        }

    }

}
