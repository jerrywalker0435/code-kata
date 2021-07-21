package com.code.kata.refactoring.ch6.composingMethods;

import java.util.List;

/**
 * @author zhangyu201
 * @date 2021/7/21
 */
public class Step3 {
    private String name;
    private List<Order> orders;

    public void printOwing(double previousAmount){
        printBanner();
        //Inline variable
        double outstanding = getOutstanding(previousAmount * 1.2);
        printDetails(outstanding);
    }
    // Rename Field
    private double getOutstanding(double outstanding) {
        for (Order order:  orders) {
             outstanding += order.getAmount();
        }
        return outstanding;
    }

    private void printDetails(double outstanding) {
        System.out.println("name:"+name);
        System.out.println("amount:"+outstanding);
    }

    private void printBanner() {
        System.out.println("*********************");
        System.out.println("****Customer Owes****");
        System.out.println("*********************");
    }






}
