package com.concurrency.ch7.s1.concurrentLinkedDeque;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author zhangyu201
 * @date 2021/8/2
 */
public class AddTask implements Runnable{
    private final ConcurrentLinkedDeque<String> list;

    public AddTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10000; i++) {
            list.add(name+": Element "+i);
        }
    }
}
