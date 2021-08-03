package com.code.kata.refactoring.book.ch7.movingFeaturesBetweenObjects.s6_removeMiddleMan.after;

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
     * a simple delegating method to the server. After adding feature for a while,it becomes painful. The server class is
     * just a middle man, and perhaps it's time for the client to call delegate directly.
     *   It's hard to figure out what the right amount of hiding is. Fortunately, with Hide Delegate and Remove Middle Man
     * it does not matter so much. You can adjust your system as time goes on. As the system changes, the basis for how
     * much you hide also changes. A good encapsulation six months ago may be awkward now. Refactoring means you never
     * have to say you're sorry -- you just fix it.
     */

    private Department department;
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public static void main(String[] args) {
        Person john = new Person();
        Person manager = john.getDepartment().getManager();
    }
}
