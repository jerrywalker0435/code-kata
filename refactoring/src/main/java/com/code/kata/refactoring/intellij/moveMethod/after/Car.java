package com.code.kata.refactoring.intellij.moveMethod.after;

import java.lang.reflect.InvocationTargetException;

/**
 * @author zhangyu201
 * @date 2021/7/29
 */
public class Car {
    private String name = "Default Car";

    Car() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
