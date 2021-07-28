package com.code.kata.refactoring.book.ch1.v7.price;

/**
 * @author zhangyu201
 * @date 2021/7/16
 */
public abstract class Price {

    public abstract int getPriceCode();

    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
