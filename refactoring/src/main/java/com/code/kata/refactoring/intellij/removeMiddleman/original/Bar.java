package com.code.kata.refactoring.intellij.removeMiddleman.original;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class Bar {
    private Foo impValue1;
    public Bar(Foo impValue) {
        impValue1 = impValue;
    }
    public Foo getImpValue() {
        return impValue1;
    }
}
