package com.code.kata.refactoring.intellij.extractRefactoring.extractField.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class Class {
    AnotherClass anotherClass;
    private int number;

    public void method(){
        int a = 1;
        number = anotherClass.intValue();
        int b = a + number;
        int c = b + number;
    }
}
