package com.code.kata.refactoring.intellij.useInterfaceWherePossible.original;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class AnotherClass {

    Class firstClass;
    Class secondClass;
    public void method() {
        firstClass.publicMethod();
        firstClass.hiddenMethod();
        secondClass.publicMethod();
        if (secondClass instanceof Class) {
        }
    }
}
