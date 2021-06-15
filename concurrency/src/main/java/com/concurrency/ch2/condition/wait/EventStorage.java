package com.concurrency.ch2.condition.wait;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangyu201
 * @date 2021/6/11
 */
public class EventStorage {
    private int maxSize;
    private Queue<Date> storage;

    public EventStorage() {
        this.maxSize = 10;
        this.storage = new LinkedList<>();
    }

    public synchronized void set() {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        storage.offer(new Date());
        System.out.printf("Set:%d\n", storage.size());
        notify();
    }

    public synchronized void get() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        String element = storage.poll().toString();
        System.out.printf("Get:%d: %s\n", storage.size(), element);
        notify();
    }
}
