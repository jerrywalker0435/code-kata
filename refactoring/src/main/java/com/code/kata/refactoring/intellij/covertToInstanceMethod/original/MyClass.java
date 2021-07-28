package com.code.kata.refactoring.intellij.covertToInstanceMethod.original;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class MyClass {
    ClassA classA = new ClassA();
    ClassB classB = new ClassB();

    public static void greatMethod(ClassA classA,ClassB classB){
        System.out.println("classA="+classA);
        System.out.println("classB="+classB);
    }

    public void myMethod(){
        MyClass.greatMethod(classA,classB);
    }

}
