package com.code.kata.refactoring.ch6.composingMethods;

import java.util.List;

/**
 * @author zhangyu201
 * @date 2021/7/21
 */
public class Step2 {
    private String name;
    private List<Order> orders;

    public void printOwing(double amount){
        printBanner();
        double outstanding = getOutstanding();
        printDetails(outstanding);
    }

    private double getOutstanding() {
        double result = 0.0;
        for (Order order:  orders) {
            result += order.getAmount();
        }
        return result;
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
