package com.code.kata.refactoring.ch6.composingMethods;

import java.util.List;

/**
 * @author zhangyu201
 * @date 2021/7/21
 */
public class Step1 {
    private String name;
    private List<Order> orders;

    public void printOwing(double amount){
        double outstanding = 0.0;
        printBanner();
        for (Order order:  orders) {
             outstanding += order.getAmount();
        }
        printDetails(outstanding);
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
