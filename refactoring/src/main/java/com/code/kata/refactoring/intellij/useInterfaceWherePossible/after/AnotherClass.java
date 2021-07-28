package com.code.kata.refactoring.intellij.useInterfaceWherePossible.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class AnotherClass {

    Class firstClass;
    Interface secondInterface;
    public void method() {
        firstClass.publicMethod();
        firstClass.hiddenMethod();
        secondInterface.publicMethod();
        if (secondInterface instanceof Interface) {
        }
    }
}
