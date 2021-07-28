package com.code.kata.refactoring.book.ch1.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu201
 * @date 2021/7/14
 */
public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();
    private Rental each;


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
            double thisAmount = amountFor(each);
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

    /**
     * Extract Method
     * @param each
     * @return
     */
    private double amountFor(Rental each) {
        this.each = each;
        double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.getDaysRented() > 2) {
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                thisAmount += 1.5;
                if (each.getDaysRented() > 3) {
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }
}
