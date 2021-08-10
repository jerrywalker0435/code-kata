package com.refactoring.pattern.ch8.s1_FormTemplateMethod.after;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public class CapitalStrategyAdvisedLine extends CapitalStrategy {

     protected double riskAmountFor(Loan loan) {
        return loan.getCommitment() * loan.getUnusedPercentage();
    }




}
