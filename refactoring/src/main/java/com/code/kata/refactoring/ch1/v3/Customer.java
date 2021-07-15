package com.code.kata.refactoring.ch1.v3;

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
     */
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : rentals) {
            double thisAmount = each.getCharge();
            frequentRenterPoints++;
            if((each.getMovie().getPriceCode()== Movie.NEW_RELEASE)&&each.getDaysRented()>1){
                frequentRenterPoints++;
            }
            result+="\t"+ each.getMovie().getTitle() + "\t" + thisAmount +"\n";

            totalAmount +=thisAmount;
        }
        result+="Amount owed is "+ totalAmount +"\n";
        result+="You earned "+ frequentRenterPoints +" frequent renter points\n";
        return result;
    }

}
