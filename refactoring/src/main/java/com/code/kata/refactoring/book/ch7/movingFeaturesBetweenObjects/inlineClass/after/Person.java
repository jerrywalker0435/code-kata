package com.code.kata.refactoring.book.ch7.movingFeaturesBetweenObjects.inlineClass.after;

/**
 * @author zhangyu201
 * @date 2021/7/23
 */
public class Person {
    /**
     * Inline Class
     * A class isn't doing very much.
     * Move all its features into another class and delete it.
     *
     * Motivation
     *   Inline Class is the reverse of Extract Class. I use Inline Class if a class is no longer pulling its weight and
     * shouldn't be around anymore. Often this is the result of refactoring that moves other responsibilities out of the
     * class, picking one that seems to use the runt class the most.
     */


     private String name;
    private String officeAreaCode;
    private String officeNumber;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficeAreaCode() {
        return officeAreaCode;
    }

    public void setOfficeAreaCode(String officeAreaCode) {
       this.officeAreaCode = officeAreaCode;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }
}
