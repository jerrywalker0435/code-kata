package com.code.kata.refactoring.intellij.extractRefactoring.extractMethod.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class AClass {

    public void method(){
        int a = 1;
        int b = 2;
        int c = add(a, b);
        int d = add(a, c);

    }

    private int add(int a, int b) {
        return a + b;
    }

}
