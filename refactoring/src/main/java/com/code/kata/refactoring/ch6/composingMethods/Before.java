package com.code.kata.refactoring.ch6.composingMethods;

import java.util.List;

/**
 * @author zhangyu201
 * @date 2021/7/21
 */
public class Before {
    private String name;
    private List<Order> orders;
    /**
     * Motivation
     *  Extract Method is one of the most common refactorings I do. I look at a method that is too long or look at code
     *  that needs to understand its purpose. I then turn that fragment of code into its own method.
     *  I prefer short, well-named methods for several reasons. First it increase then chances that other method can use
     *  a method when the method is finely grained. Second, it allows the higher-level methods to read mre like a series
     *  of comments. Overriding also is easier when the methods are finely grained.
     *  It dose take a little getting used to if you are used to seeing larger methods. And small methods really work only
     *  when you have good names, so you need to pay attention to naming. People sometimes ask me what length I look for
     *  in a method. To me length is not the issue. The key is the semantic distance between the method name and the method
     *  body. If extracting improves clarity, do it, even if the name is longer than the code you have extracted.
     */
    public void printOwing(double amount){
        double outstanding = 0.0;
        System.out.println("*********************");
        System.out.println("****Customer Owes****");
        System.out.println("*********************");
        for (Order order:  orders) {
            outstanding += order.getAmount();
        }
        System.out.println("name:"+name);
        System.out.println("amount:"+outstanding);
    }

    private void printBanner() {
    }
}
