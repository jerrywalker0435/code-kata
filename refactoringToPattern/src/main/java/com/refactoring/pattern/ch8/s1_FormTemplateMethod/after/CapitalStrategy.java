package com.refactoring.pattern.ch8.s1_FormTemplateMethod.after;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public abstract class CapitalStrategy {
    public double capital(Loan loan) {
        return riskAmountFor(loan) * duration(loan) * riskFactorFor(loan);

    }

    protected abstract double riskAmountFor(Loan loan);

    protected double duration(Loan loan) {
        return 0;
    }

    protected double riskFactorFor(Loan loan) {
        return duration(null);
    }
}
