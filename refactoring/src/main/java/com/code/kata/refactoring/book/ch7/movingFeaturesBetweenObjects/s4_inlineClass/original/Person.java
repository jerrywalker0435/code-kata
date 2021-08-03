package com.code.kata.refactoring.book.ch7.movingFeaturesBetweenObjects.s4_inlineClass.original;

/**
 * @author zhangyu201
 * @date 2021/7/23
 */
public class Person {
    private final Telephone telephone = new Telephone();
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficeAreaCode() {
        return telephone.getOfficeAreaCode();
    }

    public void setOfficeAreaCode(String officeAreaCode) {
        this.telephone.setOfficeAreaCode(officeAreaCode);
    }

    public String getOfficeNumber() {
        return telephone.getOfficeNumber();
    }

    public void setOfficeNumber(String officeNumber) {
        this.telephone.setOfficeNumber(officeNumber);
    }
}
