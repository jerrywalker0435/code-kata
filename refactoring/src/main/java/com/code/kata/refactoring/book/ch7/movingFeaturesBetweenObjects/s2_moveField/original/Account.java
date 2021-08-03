package com.code.kata.refactoring.book.ch7.movingFeaturesBetweenObjects.s2_moveField.original;

/**
 * @author zhangyu201
 * @date 2021/7/29
 */
public class Account {
    /**
     * Move Field
     * A field is, or will be, used by another class more than the class on witch it is defined.
     * Create a new field in the target class, and change all its users.
     *
     * Motivation
     *   Moving state and behavior between classes is the very essence of refactoring. As the system develops, you find
     * the need for new classes and the need to shuffle responsibilities around. A design decision that is reasonable and
     * correct on week can become incorrect in another.That is not a problem; the only problem is not to do something
     * about it.
     *   I consider moving a field if I see more methods on another class using the field than the class itself. This
     * usage may be indirect, through getting and setting methods. I may choose to move the methods; this decision based
     * on interface. But if the methods seem sensible where they are, I move the field.
     *   Another reason for field moving is when doing Extract Class. In that case the fields go first and then the methods.
     */

    private AccountType type;
    private double interestRate;

    double interestForAmountDays(double amount,int days){
        return interestRate * amount * days /365;
    }

}
