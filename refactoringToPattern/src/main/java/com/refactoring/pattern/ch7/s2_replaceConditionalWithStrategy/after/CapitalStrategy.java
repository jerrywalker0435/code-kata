package com.refactoring.pattern.ch7.s2_replaceConditionalWithStrategy.after;

import java.util.Date;

/**
 * @author zhangyu201
 * @date 2021/8/6
 */
public abstract class CapitalStrategy {
    private static final int MILLIS_PER_DAY = 86400000;
    private static final int DAYS_PER_YEAR = 365;

    public abstract double capital(Loan loan);

    double riskFactor(Loan loan) {
        return RiskFactor.getFactors().forRating(loan.getRiskRating());
    }

    double duration(Loan loan) {
        return yearsTo(loan.getExpiry(),loan);
    }

    double yearsTo(Date endDate,Loan loan) {
        Date beginDate = (loan.getToday()==null?loan.getStart():loan.getToday());
        return ((endDate.getTime()-beginDate.getTime())/MILLIS_PER_DAY)/DAYS_PER_YEAR;
    }

}
