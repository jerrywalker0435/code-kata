package com.code.kata.refactoring.book.ch6.composingMethods.s1_extractMethod;

import java.util.List;

/**
 * @author zhangyu201
 * @date 2021/7/21
 */
public class E3ReassigningALocalVariable {
    private String name;
    private List<Order> orders;

    /**
        Reassigning a Local Variable
        1.If you see an assignment to a parameter, you should immediately use
     Remove Assignment To Parameters(移除对参数的赋值 107)
        2. For temps that are assigned to,there are two case.
        2.1 The simpler case is that in which the variable is a temporary variable used only within the extracted code.
            you can make the change in just the extracted code.
        2.2 The other case is use of the variable outside the code.
            you need to make the extracted code return the changed value of the variable.
     */
    public void printOwing(double amount){
        printBanner();
        double outstanding = getOutstanding();
        printDetails(outstanding);
    }

    /**
     * The outstanding is used in both places, so I need to return it from the extracted method.
     * Once I've compiled and tested for the extraction, I rename the return value to follow my usual convention.
     *
     * In this case the outstanding variable is initialized only to an obvious initial value, so I can initialize
     * it only within the extracted method.
     */
    private double getOutstanding() {
        double result = 0.0;
        for (Order order:  orders) {
            result += order.getAmount();
        }
        return result;
    }

    /**
     * What happens if more than one variable needs to be returned?
     * The best option usually is to pick different code to extract. I prefer a method to return one value, so I would
     * arrange multiple methods for the different values.
     *
     * Temporary variables often are so plentiful that they make extraction very awkward. In these cases I try to reduce
     * the temps by Using Replace Temp With Query(以查询取代临时变量 97). If whatever I do things are still awkward, I resort
     * to Replace Method With Method Object(以函数对象取代函数 110). This refactoring doesn't care how many temporaries you
     * have or what you do with them.
     */
    public void printOwing2(double previousAmount){
        printBanner();
        double outstanding = getOutstanding2(previousAmount * 1.2);
        printDetails(outstanding);
    }

    /**
     * If something more involved happens to the variable, I have to pass in the previous value as a parameter.
     */
    private double getOutstanding2(double initial) {
        double outstanding = initial;
        for (Order order:  orders) {
            outstanding += order.getAmount();
        }
        return outstanding;
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
