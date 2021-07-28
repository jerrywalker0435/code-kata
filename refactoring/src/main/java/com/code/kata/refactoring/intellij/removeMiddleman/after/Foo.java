package com.code.kata.refactoring.intellij.removeMiddleman.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class Foo {
    Bar bar;
    public Foo getImpValue() {
        return bar.getImpValue();
    }
}
