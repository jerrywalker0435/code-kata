package com.code.kata.refactoring.book.ch7.movingFeaturesBetweenObjects.hideDelegate.after;

/**
 * @author zhangyu201
 * @date 2021/7/29
 */
public class Department {
    private String chargeCode;
    private Person manager;

    public Person getManager() {
        return manager;
    }

    public void setManager(Person manager) {
        this.manager = manager;
    }
}
