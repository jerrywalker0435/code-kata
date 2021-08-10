package com.refactoring.pattern.ch8.s1_FormTemplateMethod.original;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public class CapitalStrategyRevolver extends CapitalStrategy{
    @Override
    public double capital(Loan loan) {
        return (loan.outstandingRiskAmount()*duration(loan)* riskFactorFor(loan))+
                (loan.unusedRiskAmount()*duration(loan)*unusedRiskFactor(loan));
    }

    private double unusedRiskFactor(Loan loan) {
        return 0;
    }

    private double riskFactorFor(Loan loan) {
        return 0;
    }

    private double duration(Loan loan) {
        return 0;
    }
}
