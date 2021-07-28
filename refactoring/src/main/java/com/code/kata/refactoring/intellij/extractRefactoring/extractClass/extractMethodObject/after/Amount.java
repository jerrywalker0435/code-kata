package com.code.kata.refactoring.intellij.extractRefactoring.extractClass.extractMethodObject.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class Amount {

    private int c;
    private int a;

    int gamma (int val1) {
       //some computations
        return new Gamma(val1).invoke();
    }

    private class Gamma {
        private int val1;

        public Gamma(int val1) {
            this.val1 = val1;
        }

        public int invoke() {
            int f = 0;
            return val1-f + c-2*a;
        }
    }
}
