package com.code.kata.refactoring.intellij.changeSignature.changeClass.after;

import java.util.Collection;
import java.util.List;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class MyClass<Param1, Param2, Param3 extends Collection> {
    public class MyOtherClass{
        MyClass<String, Integer, List> myClass;

        void myMethod(MyClass<String, Integer, List> myClass){

        }
    }
}
