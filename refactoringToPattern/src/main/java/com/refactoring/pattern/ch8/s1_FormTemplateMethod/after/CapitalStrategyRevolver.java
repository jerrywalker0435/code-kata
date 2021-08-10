package com.refactoring.pattern.ch8.s1_FormTemplateMethod.after;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public class CapitalStrategyRevolver extends CapitalStrategy {
    @Override
    public double capital(Loan loan) {
        return super.capital(loan)+ unusedCapital(loan);
    }

    private double unusedCapital(Loan loan) {
        return loan.unusedRiskAmount()*duration(loan)*unusedRiskFactor(loan);
    }

    @Override
    protected double riskAmountFor(Loan loan) {
        return loan.outstandingRiskAmount();
    }

    private double unusedRiskFactor(Loan loan) {
        return riskFactorFor(null);
    }

}
