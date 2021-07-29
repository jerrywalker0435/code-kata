package com.code.kata.refactoring.book.ch7.movingFeaturesBetweenObjects.hideDelegate.after;

/**
 * @author zhangyu201
 * @date 2021/7/29
 */
public class Person {


    /**
     * Hide Delegate
     * A client is calling a delegate class of an object.
     * Create a method on the server to hide the delegate.
     *
     * Motivation
     *   One of the keys, if not the key, to object is encapsulation. Encapsulation means that objects need to know less
     * about other parts of system. Then when things change, fewer objects need to be told about the change--which makes
     * the change easier to make.
     *   Anyone involved in objects knows that you should hide your fields, despite the fact that Java allows fields to
     * be public. As you become more sophisticated, you realize there is more you can encapsulate.
     *   If a client calls a method on one of the fields of the server object, the client needs to know about this delegate
     * object. If the delegate changes, the client is also may have to change. You can remove this dependency by placing
     * a simple delegating method on the server, which hides the delegate. Changes become limited to the server and don't
     * propagate to the client.
     *   You may find it is worthwhile to use Extract Class for some clients of the server of all clients. If you hide from
     * all clients, you can remove all mention of the delegate form the interface of the server.
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
