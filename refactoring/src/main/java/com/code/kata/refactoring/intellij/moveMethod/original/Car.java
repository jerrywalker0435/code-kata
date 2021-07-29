package com.code.kata.refactoring.intellij.moveMethod.original;

import java.lang.reflect.InvocationTargetException;

/**
 * @author zhangyu201
 * @date 2021/7/29
 */
public class Car {
    String name = "Default Car";

    Car() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    }

    String getName(Test anotherObject){
        System.out.print(anotherObject.toString());
        return this.name;
    }
}
