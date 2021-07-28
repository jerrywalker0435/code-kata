package com.code.kata.refactoring.intellij.replaceConstructorWithFactoryMethod.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class Class {
    private Class(String s) {
    }

    public static Class createClass(String s) {
        return new Class(s);
    }
}



