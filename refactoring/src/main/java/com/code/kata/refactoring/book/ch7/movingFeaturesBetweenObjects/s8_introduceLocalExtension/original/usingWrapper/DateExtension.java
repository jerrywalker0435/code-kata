package com.code.kata.refactoring.book.ch7.movingFeaturesBetweenObjects.s8_introduceLocalExtension.original.usingWrapper;

import java.util.Date;


/**
 * Introduce Local Extension
 * A server class you are using needs several additional methods, but you can't modify the class
 * Create a new class that contains these extra methods. Make this extension class a subclass or a wrapper of the
 * original.
 * <p>
 * Motivation
 * Authors of classes sadly are not omniscient, and they fail to provide useful methods for you. If you can modify
 * the source, often the best thing is to add that method. However, you often can't modify the source. If you need
 * or two methods, you can use Introduce Foreign Method. Once you get beyond a couple of these methods, however,
 * they get out of hand. So you need to group the methods together in a sensible place for them. The standard
 * object-oriented techniques of subclassing and wrapping are an obvious way to do this. In these circumstances I call
 * the subclass or wrapper a local extension.
 * A local extension is a separate class, but it is a subtype of the class it is extending. That means it supports
 * all the things the original can do but also adds the extra features. Instead of using the original class, you
 * instantiate the local extension and use it.
 * By using the local extension you keep to the principle that methods and data should be packaged into well-formed
 * units. If you keep putting code in other classes that should lie in the extension, you end up complicating the other
 * classes, and making it harder to reuse these methods.
 * In choosing between subclass and wrapper, I usually prefer the subclass because it's less work. The biggest roadblock
 * to a subclass is that it needs to apply at object-creation time. If I can take over the creation process that's no
 * problem. The problem occurs if you apply the local extension later. Subclassing forces me to create a new object
 * of that subclass. If other objects refer to the old one, I have two objects with the original's data. If the original
 * is immutable, there is no problem; I can safely take a copy. But if the original can change, there is a problem,
 * because changes in one object won't change the other and I have to use a wrapper. That way changes made through
 * the local extension affect the original object and vice versa.
 */
public class DateExtension {
    private Date original;

    public DateExtension(String date) {
        this.original = new Date(date);
    }

    public DateExtension(Date date) {
        this.original = date;
    }

    public int getYear(){
        return original.getYear();
    }
    public  Date nextDay(Date previousEnd) {
        return new Date(previousEnd.getYear(),previousEnd.getMonth(),previousEnd.getDate()+1);
    }
}
