package com.code.kata.refactoring.intellij.removeMiddleman.original;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class Client {
    Foo a;
    Foo impValue = a.getBar().getImpValue();
}
