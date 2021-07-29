package com.code.kata.refactoring.book.ch7.movingFeaturesBetweenObjects.moveField.after;

/**
 * @author zhangyu201
 * @date 2021/7/29
 */
public class AccountType {
    private double interestRate;

    public double getInterestRate() {
        return interestRate;
    }

    public  void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
