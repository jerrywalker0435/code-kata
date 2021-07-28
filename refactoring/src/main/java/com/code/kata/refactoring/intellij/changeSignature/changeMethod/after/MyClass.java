package com.code.kata.refactoring.intellij.changeSignature.changeMethod.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class MyClass {

    void myMethod(int value, double price) {

    }

    public class MyOtherClass{
        public void myMethodCall(MyClass myClass){
            double d = 0.5;
            myClass.myMethod(1, 0.0);
        }
    }
}
