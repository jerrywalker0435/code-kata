package com.code.kata.refactoring.ch1.v4;

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
        double result = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (getDaysRented() > 2) {
                    result += (getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (getDaysRented() > 3) {
                    result += (getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    int getFrequentRenterPoints() {
        if((getMovie().getPriceCode()== Movie.NEW_RELEASE)&& getDaysRented()>1){
            return 2;
        }else {
            return 1;
        }
    }
}
