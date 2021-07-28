package com.code.kata.refactoring.book.ch1.v4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu201
 * @date 2021/7/14
 */
public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();


    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }
    /**
     * when you find you have to add a feature to a program, and the program's code is not
     * structured in convenient way to the feature, first refactor the program to make it
     * easy to add the feature,then add the feature.
     *
     * Inline Variable
     *   variable not changed afterward
     */
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : rentals) {
            frequentRenterPoints += each.getFrequentRenterPoints();
            result+="\t"+ each.getMovie().getTitle() + "\t" + each.getCharge() +"\n";

            totalAmount += each.getCharge();
        }
        result+="Amount owed is "+ totalAmount +"\n";
        result+="You earned "+ frequentRenterPoints +" frequent renter points\n";
        return result;
    }

}
