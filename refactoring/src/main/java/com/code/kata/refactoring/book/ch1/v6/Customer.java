package com.code.kata.refactoring.book.ch1.v6;

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
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : rentals) {
            result+="\t"+ each.getMovie().getTitle() + "\t" + each.getCharge() +"\n";
        }
        result+="Amount owed is "+ getTotalCharge() +"\n";
        result+="You earned "+ getTotalFrequentRenterPoints() +" frequent renter points\n";
        return result;
    }

    public String htmlStatement() {
        String result = "<H1>Rental Record for <EM> " + getName() + "</EM></P>\n";
        for (Rental each : rentals) {
            result+= each.getMovie().getTitle() + ":" + each.getCharge() +"</BR>\n";
        }
        result+="<P>You owed is "+ getTotalCharge() +"</P>\n";
        result+="On this rental You earned <EM>"+ getTotalFrequentRenterPoints() +" </EM> frequent renter points<P>\n";
        return result;
    }
    /**
     * Replace Temp with Query
     *   temporary variables can be a problem. They are useful only within their own routine,
     *   and
     */
    private double getTotalCharge(){
        double totalAmount = 0;
        for (Rental each : rentals) {
            totalAmount += each.getCharge();
        }
        return totalAmount;
    }
    private double getTotalFrequentRenterPoints(){
        double frequentRenterPoints = 0;
        for (Rental each : rentals) {
            frequentRenterPoints += each.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

}
