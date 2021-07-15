package com.code.kata.refactoring.ch1.v7.price;

import com.code.kata.refactoring.ch1.v7.Movie;

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
