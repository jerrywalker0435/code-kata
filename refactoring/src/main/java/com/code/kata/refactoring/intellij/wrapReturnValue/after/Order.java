package com.code.kata.refactoring.intellij.wrapReturnValue.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class Order {
    String customer;

    Wrapper getCustomer() {
        return new Wrapper(customer);
    }
}



