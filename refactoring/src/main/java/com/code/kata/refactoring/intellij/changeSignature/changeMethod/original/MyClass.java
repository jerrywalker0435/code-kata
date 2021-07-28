package com.code.kata.refactoring.intellij.changeSignature.changeMethod.original;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class MyClass {

    void myMethod(int value) {

    }

    public class MyOtherClass{
        public void myMethodCall(MyClass myClass){
            double d = 0.5;
            myClass.myMethod(1);
        }
    }
}
