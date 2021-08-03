package com.code.kata.refactoring.book.ch7.movingFeaturesBetweenObjects.s7_introduceForeignMethod.original;

import java.util.Date;

/**
 * @author zhangyu201
 * @date 2021/7/29
 */
public class DataUtil {
    private Date previousEnd;

    /**
     * Introduce Foreign Method
     * A server class you are using needs an additional method, but you can't modify the class.
     * Create a method in the client class with an instance of the server class as its first argument.
     *
     * Motivation
     *   It often happens enough. You are using this really nice class that gives you all these great services. Then there
     * is one service it doesn't give you but should. You curse the class, saying,"Why don't you do that?" If you can change
     * the source, you can add in the method.If you can't change the source,you have to code around the lack of the method
     * in the client.
     *   If you use the method only once in the client class then the extra coding is no big deal and probably wasn't needed
     * on the original class anyway. If you use the method several times, however, you have to repeat this coding around.
     * Because repetition is the root of all software evil, this repetitive code should be factored into a single method.
     * When you do this refactoring, you can clearly signal that this method is really a method that should be on the original
     * by making it a foreign method.
     *   If you find yourself creating many foreign methods on a server class, or you find many of your classes need the same
     * foreign method, you should use Introduce Local Extension instead.
     *   Don't forget that foreign methods are a work-around. If you can,try to get the methods moved to their proper homes.
     * If code owner to implement the method for you.
     *
     */
     public void introduceForeignExtension(){
         Date newStart = new Date(previousEnd.getYear(),previousEnd.getMonth(),previousEnd.getDate()+1);
     }
}
