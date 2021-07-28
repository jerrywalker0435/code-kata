package com.code.kata.refactoring.intellij.replaceTempWithQuery.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class Class {
    public void method() {
        String str = "str";
        System.out.println(aString(str));
    }

    private String aString(String str) {
        return returnString().concat(str);
    }

    private String returnString() {
        return "";
    }
}



