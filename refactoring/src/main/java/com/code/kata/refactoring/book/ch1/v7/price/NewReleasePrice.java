package com.code.kata.refactoring.book.ch1.v7.price;

import com.code.kata.refactoring.book.ch1.v7.Movie;

/**
 * @author zhangyu201
 * @date 2021/7/16
 */
public class NewReleasePrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
       return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        if(daysRented >1){
            return 2;
        }else {
            return 1;
        }
    }
}
