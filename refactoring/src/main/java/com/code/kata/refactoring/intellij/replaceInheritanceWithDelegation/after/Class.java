package com.code.kata.refactoring.intellij.replaceInheritanceWithDelegation.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class Class {
    private final MySuperClass superClass = new MySuperClass();
    public int varInt;

    private class MySuperClass extends SuperClass {
        public void openMethod() {
        }
    }
}



