package com.code.kata.refactoring.intellij.extractRefactoring.extractClass.extractDelegate.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class Foo {

    private final Info info = new Info();

    public String getInfo() {
        return info.getInfo();
    }
}
