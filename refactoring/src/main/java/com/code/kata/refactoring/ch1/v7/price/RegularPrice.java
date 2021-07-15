package com.code.kata.refactoring.ch1.v7.price;

import com.code.kata.refactoring.ch1.v7.Movie;

/**
 * @author zhangyu201
 * @date 2021/7/16
 */
public class RegularPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getCharge(int daysRented) {
        double result= 2;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}
