package com.concurrency.ch2.condition.wait;

/**
 * @author zhangyu201
 * @date 2021/6/11
 */
public class Producer implements Runnable{
    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.set();
        }
    }

}
