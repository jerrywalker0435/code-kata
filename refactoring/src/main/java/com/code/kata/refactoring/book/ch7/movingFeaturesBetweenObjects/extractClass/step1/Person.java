package com.code.kata.refactoring.book.ch7.movingFeaturesBetweenObjects.extractClass.step1;

/**
 * @author zhangyu201
 * @date 2021/7/23
 */
public class Person {
    /**
     * You have one class doing work that should be done by two.
     * Create a new class and move the relevant fields and methods form the old class into the new class.
     * <p>
     * Motivation
     * You've probably heard that a class should be a crisp abstraction, hand a few clear responsibilities, or some
     * similar guideline. In practice, class grow. You add some operations here, a bit of data there. You add responsibility
     * to a class feeling that it's not worth a separate class, but as that responsibility grows and breeds, the class
     * becomes too complicated. Soon your class is as crisp as a microwaved duck.
     * Such a class is one with many methods and quite a lot of data. A class that is too big to understand easily.
     * You need to consider where it can be split, and you split it. A good sign is that a subset of the data and a subset
     * of methods seem to go together. Other good signs are subsets of data usually change together or are particularly
     * dependent on each other. A useful test is to ask yourself what would happen if you removed a piece of data or a
     * method. What other fields and methods would become nonsense?
     * One sign that often crops up later in development is the way the class is subtyped. You may find that subtyping
     * affects only a few feature or that some features need to subtyped one way and other features a different way.
     */


    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
