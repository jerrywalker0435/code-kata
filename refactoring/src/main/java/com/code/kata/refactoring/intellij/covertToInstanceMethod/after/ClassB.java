package com.code.kata.refactoring.intellij.covertToInstanceMethod.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class ClassB {
    public void greatMethod(ClassA classA){
        System.out.println("classA="+classA);
        System.out.println("classB="+ this);
    }
}
