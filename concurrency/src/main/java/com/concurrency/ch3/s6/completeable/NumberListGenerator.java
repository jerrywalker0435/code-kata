package com.concurrency.ch3.s6.completeable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author zhangyu201
 * @date 2021/6/17
 */
public class NumberListGenerator implements Supplier<List<Long>> {
    private final int size;

    public NumberListGenerator(int size) {
        this.size = size;
    }

    @Override
    public List<Long> get() {
        List<Long> ret = new ArrayList<>();
        System.out.printf("%s : NumberListGenerator : Start\n",Thread.currentThread().getName());
        for (int i = 0; i < size * 1000000; i++) {
            long number = Math.round(Math.random()*Long.MAX_VALUE);
            ret.add(number);
        }
        System.out.printf("%s : NumberListGenerator : End\n",Thread.currentThread().getName());
        return ret;
    }
}
