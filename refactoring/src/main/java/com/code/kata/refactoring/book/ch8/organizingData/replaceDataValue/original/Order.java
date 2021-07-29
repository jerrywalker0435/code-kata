package com.code.kata.refactoring.book.ch8.organizingData.replaceDataValue.original;

import java.util.Collection;
import java.util.Iterator;

/**
 * Replace Data Value
 * You have a data item that needs additional data or behavior.
 * Turn the data item into an object.
 * Motivation
 *   Often in early stages of development you make a decisions about representing simple facts as simple as data item.
 * As development proceeds you realize that those simple items aren't so simple anymore.A telephone number may be represented
 * as a string for a while,but later you realize that the telephone needs special behavior for formatting,extracting the area
 * code,and the like.For one or two items you may put the methods in the owning object,but quickly the code smells of
 * duplication and feature envy.When the smell begins,turn the data value into an object.
 */
public class Order {
    private String customer;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    private static int numberOfOrdersFor(Collection orders,String customer){
        int result = 0 ;
        Iterator iter = orders.iterator();
        while (iter.hasNext()){
            Order each =(Order) iter.next();
            if (each.getCustomer().equals(customer)) {
                result++;
            }
        }
        return result;
    }
}
