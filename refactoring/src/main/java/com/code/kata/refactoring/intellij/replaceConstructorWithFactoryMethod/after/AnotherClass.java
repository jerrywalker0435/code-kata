package com.code.kata.refactoring.intellij.replaceConstructorWithFactoryMethod.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class AnotherClass {

    public void method() {
        Class aClass = Class.createClass("string");
    }
}
