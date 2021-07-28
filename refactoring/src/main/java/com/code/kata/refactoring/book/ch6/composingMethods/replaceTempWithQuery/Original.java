package com.code.kata.refactoring.book.ch6.composingMethods.replaceTempWithQuery;

/**
 * @author zhangyu201
 * @date 2021/7/23
 */
public class Original {

    /**
     * You are using a temporary variable to hold the result of an expression.
     * Extract the expression into a method. Replace all references to the temp with the expression. The new method can
     * then be used in other methods.
     *
     * The problem with temps is that they are temporary and local. Because they can be seen only in the context of the
     * method in which they are used, temps tend to encourage longer methods, because that's the only way you can reach
     * the temp. By replacing the temp with a query method. any method in the class can get at the information. That help
     * a lot in coming up with cleaner code for the class.
     *
     * Replace Temp With Query often is a vital step before Extract Method. Local variables make it difficult to extract,
     * so replace as many variables as you can with queries.
     *
     * The straightforward cases of this refactoring are those in witch temps are assigned only to once and those in which
     * the expression that generates the assignment if free of side effects. Other case are trickier but possible. You
     * may need to use Split Temporary Variable(分解临时变量 104) or Separate Query From Modifier(将查询函数与修改函数分离 225)
     * first to make things easier. If the temp is used to collect a result(such as summing over a loop),you need to
     * copy some logic into query method.
     *
     * Temps often are used to store summary information in loops. The entire loop can be extracted into a method; this
     * removes several lines of noisy code. Sometimes a loop may be used to sum up multiple values. In this case, duplicate
     * the loop for each temp so that you can replace each temp with a query. The loop should be very simple, so there
     * is little danger in duplicating code.
     *
     * You may be concerned about performance in this case. As with other performance issues, let it side for the moment.
     * Nine times out of ten, it won't matter. When it does matter, you'll fix the problem during optimization. With your
     * code better factored, you'll often find more powerful optimizations, witch you would have missed without refactoring.
     * If worse comes to worse, it's very easy to put the temp back.
     *
     * Note
     *  - Look for a temporary variable that is assigned to once.
     *      ? If a temp is set more than once consider Split Temporary Variable
     *  - Extract the right-hand side of the assignment into a method.
     *      ? Ensure the extracted method is free of side effects, that is, it doesn't modify any object. If it's not
     *      free of side effects, use Separate Query From Modifier
     */
    private int quantity;
    private int itemPrice;

    double getPrice(){
        int basePrice = quantity * itemPrice;
        double discountFactor;
        if(basePrice > 1000) {
            discountFactor = 0.95;
        }else {
            discountFactor = 0.98;
        }
        return basePrice * discountFactor;
    }
}
