package com.code.kata.refactoring.ch1.v7;

/**
 * @author zhangyu201
 * @date 2021/7/14
 */
public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }

    /**
     * Extract Method
     * Rename
     *  Good code should communicate what is doing clearly and variable names are key to clear code.
     *  Any fool can write code that a computer can understand. Good programmers write code that humans understand.
     * Move Method
     *  In most cases a method should be on the object whose data it uses.
     *
     *
     * @return
     */
    protected double getCharge() {
        return movie.getCharge(this.getDaysRented());
    }

    public int getFrequentRenterPoints() {
        return movie.price.getFrequentRenterPoints(this.getDaysRented());
    }

}
