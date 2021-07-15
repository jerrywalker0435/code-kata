package com.code.kata.refactoring.ch1.v6;

/**
 * @author zhangyu201
 * @date 2021/7/14
 */
public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE= 1;

    private String title;
    private int priceCode;


    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * Move method
     *
     *
     *   Why do I prefer to pass the daysRented to the movie rather than
     *   the movie type to the rental?
     *   It's because the purposes of changes are all about adding new types.
     *
     * @param daysRented
     * @return
     */
    public double getCharge(int daysRented) {
        double result = 0;
        switch (getPriceCode()) {
            case REGULAR:
                result += 2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                result += daysRented * 3;
                break;
            case CHILDREN:
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    public int getFrequentRenterPoints(int daysRented) {
        if((getPriceCode()== NEW_RELEASE)&& daysRented >1){
            return 2;
        }else {
            return 1;
        }
    }
}
