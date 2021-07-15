package com.code.kata.refactoring.ch1.v7;

import com.code.kata.refactoring.ch1.v7.price.ChildrenPrice;
import com.code.kata.refactoring.ch1.v7.price.NewReleasePrice;
import com.code.kata.refactoring.ch1.v7.price.Price;
import com.code.kata.refactoring.ch1.v7.price.RegularPrice;

/**
 * @author zhangyu201
 * @date 2021/7/14
 */
public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE= 1;

    private String title;
    Price price;


    /**
     * Self Encapsulate Filed
     *
     *
     * @param title
     * @param priceCode
     */
    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode){
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDREN:
                price = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("incorrect price code");
        }
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
        return price.getCharge(daysRented);
    }

}
