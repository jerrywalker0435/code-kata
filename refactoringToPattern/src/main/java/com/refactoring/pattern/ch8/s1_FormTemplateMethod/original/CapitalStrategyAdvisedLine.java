package com.refactoring.pattern.ch8.s1_FormTemplateMethod.original;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public class CapitalStrategyAdvisedLine extends CapitalStrategy{
    @Override
    public double capital(Loan loan) {
        return loan.getCommitment()*loan.getUnusedPercentage()*duration(loan)* riskFactorFor(loan);

    }


    private double riskFactorFor(Loan loan) {
        return 0;
    }

    private double duration(Loan loan) {
        return 0;
    }
}
