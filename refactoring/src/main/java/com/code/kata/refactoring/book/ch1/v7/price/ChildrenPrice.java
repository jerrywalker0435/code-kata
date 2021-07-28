package com.code.kata.refactoring.book.ch1.v7.price;

import com.code.kata.refactoring.book.ch1.v7.Movie;

/**
 * @author zhangyu201
 * @date 2021/7/16
 */
public class ChildrenPrice extends Price {
    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }

    @Override
    public int getPriceCode() {
        return Movie.CHILDREN;
    }
}
