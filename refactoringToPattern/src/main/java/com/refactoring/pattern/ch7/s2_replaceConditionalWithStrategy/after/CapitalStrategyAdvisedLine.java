package com.refactoring.pattern.ch7.s2_replaceConditionalWithStrategy.after;

/**
 * @author zhangyu201
 * @date 2021/8/6
 */
public class CapitalStrategyAdvisedLine extends CapitalStrategy {
    public double capital(Loan loan) {

        return loan.getCommitment() * loan.getUnusedPercentage() * duration(loan) * riskFactor(loan);

    }

}
