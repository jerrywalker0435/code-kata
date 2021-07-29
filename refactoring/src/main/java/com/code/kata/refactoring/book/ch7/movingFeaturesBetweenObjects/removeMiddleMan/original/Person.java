package com.code.kata.refactoring.book.ch7.movingFeaturesBetweenObjects.removeMiddleMan.original;

/**
 * @author zhangyu201
 * @date 2021/7/29
 */
public class Person {


    /**
     * Remove Middle Man
     * A class is doing too much delegation.
     * Get the client to call the delegate directly.
     * Motivation
     *   In the motivation for Hide Delegate. I talked about the advantage of encapsulating the use of a delegated object.
     * There is a price for this. The price is that every time wants to use a new feature of the delegate, you have to add
     * a simple delegating method to the server. After adding feature for a while
     */

    private Department department;
    public Department getDepartment() {
        return department;
    }
    public Person getManager(){
        return department.getManager();
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    public static void main(String[] args) {
        Person john = new Person();
        Person manager = john.getManager();
    }
}
