package com.code.kata.refactoring.intellij.extractRefactoring.extractField.original;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class Class {
    AnotherClass anotherClass;
    public void method(){
        int a = 1;
        int b = a + anotherClass.intValue();
        int c = b + anotherClass.intValue();
    }
}
