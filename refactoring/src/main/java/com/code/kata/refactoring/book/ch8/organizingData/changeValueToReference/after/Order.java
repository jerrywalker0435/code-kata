package com.code.kata.refactoring.book.ch8.organizingData.changeValueToReference.after;

import java.util.Collection;
import java.util.Iterator;

/**
 * Change Value To Reference
 * You have a class with many equal instances that you want to replace with a single object.
 * Turn the object into a reference object.
 * Motivation
 *   You can make a useful classification of objects in many systems: reference objects and value objects. Reference objects
 * are things like customer or account.Each object stands for one object in the real world,and you use the object identity
 * to test whether they are equal. Value Objects are things like data or money.They are defined entirely through their data
 * values.You don't mind that copies exist;you may have hundreds of "1/1/2000" objects around your system.You do need to
 * tell whether two of the objects are equal,so you need to override the equals method and hashCode method too.
 *   The decision between reference and value is not always clear.Sometimes you start with a simple value with a small
 * amount of immutable data.Then you want to give it some changeable data and ensure that the changes ripple to everyone
 * referring to the object.At this point you need to turn it into a reference object.
 */
public class Order {
    private Customer customer;

    public Order(String customer) {
        this.customer= Customer.createCustomer(customer);
    }

    public String getCustomerName() {
        return customer.getName();
    }



    private static int numberOfOrdersFor(Collection orders,String customer){
        int result = 0 ;
        Iterator iter = orders.iterator();
        while (iter.hasNext()){
            Order each =(Order) iter.next();
            if (each.getCustomerName().equals(customer)) {
                result++;
            }
        }
        return result;
    }
}
