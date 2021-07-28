package com.code.kata.refactoring.intellij.replaceConstructorWithBuilder.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class Variety {

    private String string;

    // constructor
    public Variety(String name) {
        string = name;
    }

    public void setName(String name) {
        string = name;
    }

    public String getName() {
        return string;
    }

    public void saying() {
        System.out.printf("On sale today : %s\n", getName());
    }
}
