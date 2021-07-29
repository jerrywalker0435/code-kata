package com.code.kata.refactoring.book.ch6.composingMethods.extractMethod;

import java.util.List;

/**
 * Motivation
 *    Extract Method is one of the most common refactorings I do. I look at a method that is too long or look at code
 *  that needs to understand its purpose. I then turn that fragment of code into its own method.
 *  I prefer short, well-named methods for several reasons. First it increase then chances that other method can use
 *  a method when the method is finely grained. Second, it allows the higher-level methods to read more like a series
 *  of comments. Overriding also is easier when the methods are finely grained.
 *    It dose take a little getting used to if you are used to seeing larger methods. And small methods really work
 *  only when you have good names, so you need to pay attention to naming. People sometimes ask me what length I
 *  look for in a method. To me length is not the issue. The key is the semantic distance between the method name
 *  and the method body. If extracting improves clarity, do it, even if the name is longer than the code you have
 *  extracted.
 *
 *   1. Create a new method, and name it after the intention of the method(name it by what it does, not how it does)
 *   2. If one variable is modified, see whether you can treat the extracted code as a query an assign the result to
 *      the variable, you can't extract the method as it stands. You may need to use Split Temporary Variable(分解临时变量 104)
 *      and try again. You can eliminate temporary variable with Replace Temp With Query(以查询取代临时变量 97)
 */
public class Original {
    private String name;
    private List<Order> orders;

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
