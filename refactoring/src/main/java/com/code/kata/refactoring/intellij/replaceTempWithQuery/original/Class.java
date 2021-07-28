package com.code.kata.refactoring.intellij.replaceTempWithQuery.original;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class Class {
    public void method() {
        String str = "str";
        String aString = returnString().concat(str);
        System.out.println(aString);
    }

    private String returnString() {
        return "";
    }
}



