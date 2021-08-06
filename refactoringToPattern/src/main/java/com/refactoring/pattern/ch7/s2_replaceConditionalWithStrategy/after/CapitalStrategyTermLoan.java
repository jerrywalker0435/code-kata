package com.refactoring.pattern.ch7.s2_replaceConditionalWithStrategy.after;

import java.util.Iterator;

/**
 * @author zhangyu201
 * @date 2021/8/6
 */
public class CapitalStrategyTermLoan extends CapitalStrategy {
    public double capital(Loan loan) {
            return loan.getCommitment() * duration(loan)* riskFactor(loan);
    }
    double duration(Loan loan) {
          return weightedAveragedDuration(loan);

    }
    private double weightedAveragedDuration(Loan loan) {
        double duration = 0.0;
        double weightedAverage = 0.0;
        double sumOfPayments = 0.0;
        Iterator<Payment> loanPayments = loan.getPayments().iterator();
        while (loanPayments.hasNext()){
            Payment payment = loanPayments.next();
            sumOfPayments += payment.amount();
            weightedAverage += yearsTo(payment.date(),loan)*payment.amount();
        }
        if(loan.getCommitment() !=0.0){
            duration = weightedAverage /sumOfPayments;
        }
        return duration;
    }

}
