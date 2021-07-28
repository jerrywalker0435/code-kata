package com.code.kata.refactoring.intellij.covertToInstanceMethod.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class MyClass {
    ClassA classA = new ClassA();
    ClassB classB = new ClassB();

    public void myMethod(){
        classB.greatMethod(classA);
    }

}
