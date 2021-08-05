package com.refactoring.pattern.ch6.s1_replaceConstructorWithCreationMethod.after;


import java.util.Date;

/**
 * @author zhangyu201
 * @date 2021/8/5
 */
public class Main {
    public static void main(String[] args) {
        double commitment = 0.0;
        double outstanding = 0.0;
        int riskRating = 1;
        Date maturity = new Date();
        Loan termLoan1 = Loan.createTermLoan(commitment, riskRating, maturity);
        CapitalStrategy riskAdjustedCapitalStrategy = new CapitalStrategyRevolver();
        Loan termLoan2 = Loan.createTermLoan(commitment, outstanding, riskRating, maturity, riskAdjustedCapitalStrategy);

    }

}
