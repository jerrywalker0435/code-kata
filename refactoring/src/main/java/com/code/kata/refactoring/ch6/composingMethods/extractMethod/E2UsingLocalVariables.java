package com.code.kata.refactoring.ch6.composingMethods.extractMethod;

import java.util.List;

/**
 * @author zhangyu201
 * @date 2021/7/21
 */
public class E2UsingLocalVariables {
    private String name;
    private List<Order> orders;

    public void printOwing(double amount){
        printBanner();
        double outstanding = 0.0;
        for (Order order:  orders) {
            outstanding += order.getAmount();
        }
        printDetails(outstanding);
    }

    /**
     Using Local Variable
     Local Variable: parameters passed into the original method and temporaries declared within the original method.
     Local variable are only in scope in that method.

     If local variables are read but not changed, just pass them as a parameter.
     */
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
