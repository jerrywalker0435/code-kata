package com.refactoring.pattern.ch7.s2_replaceConditionalWithStrategy.after;

import java.util.Date;
import java.util.List;

/**
 * @author zhangyu201
 * @date 2021/8/6
 */
public class Loan {
    private double commitment;
    private double outstanding;
    private int riskRating;
    private Date maturity;
    private Date expiry;
    private List<Payment> payments;
    private CapitalStrategy capitalStrategy;

    public Loan(double commitment, int riskRating, Date maturity) {
        this(commitment, 0.00, riskRating, maturity, null);
    }

    public Loan(double commitment, double outstanding, int riskRating, Date maturity, Date expiry) {
        this(null, commitment, outstanding, riskRating, maturity, expiry);
    }

    public Loan(double commitment, int riskRating, Date maturity, Date expiry) {
        this(commitment, 0.00, riskRating, maturity, expiry);
    }

    public Loan(CapitalStrategy capitalStrategy, double commitment, int riskRating, Date maturity, Date expiry) {
        this(capitalStrategy, commitment, 0.00, riskRating, maturity, expiry);
    }

    public Loan(CapitalStrategy capitalStrategy, double commitment, double outstanding, int riskRating, Date maturity, Date expiry) {
        this.commitment = commitment;
        this.outstanding = outstanding;
        this.riskRating = riskRating;
        this.maturity = maturity;
        this.expiry = expiry;
        this.capitalStrategy = capitalStrategy;
    }
    public double capital() {
        return capitalStrategy.capital(this);
    }

    static Loan newTermLoan(double commitment, double outstanding, int riskRating, Date maturity) {
        return new Loan(new CapitalStrategyTermLoan(), commitment, outstanding, riskRating, maturity, null);
    }
    static Loan newRevolver(double commitment, double outstanding, int riskRating ,Date expiry) {
        return new Loan(new CapitalStrategyRevolver(), commitment, outstanding, riskRating, null, expiry);
    }
    static Loan newAdvisedLine(double commitment, double outstanding, int riskRating ,Date maturity,Date expiry) {
        return new Loan(new CapitalStrategyAdvisedLine(), commitment, outstanding, riskRating, maturity, expiry);
    }
    protected double unusedRiskAmount() {
        return getCommitment() - outstanding;
    }

    protected double outstandingRiskAmount() {
        return outstanding;
    }

    protected double getUnusedPercentage() {
        return 0;
    }


    public double getCommitment() {
        return commitment;
    }

    public void setCommitment(double commitment) {
        this.commitment = commitment;
    }

    public Date getMaturity() {
        return maturity;
    }

    public void setMaturity(Date maturity) {
        this.maturity = maturity;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public int getRiskRating() {
        return riskRating;
    }

    public void setRiskRating(int riskRating) {
        this.riskRating = riskRating;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Date getToday() {
        return new Date();
    }

    public Date getStart() {
        return new Date();
    }
}
