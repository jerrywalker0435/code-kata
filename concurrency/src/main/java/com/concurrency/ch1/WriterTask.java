package com.concurrency.ch1;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyu201
 * @date 2021/6/10
 */
public class WriterTask implements Runnable{

    private Deque<Event> deque;

    public WriterTask(Deque<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Event event = new Event();
            event.setDate(new Date());
            event.setEvent(String.format("the thread %s has generated an event",Thread.currentThread().getId()));
            deque.addFirst(event);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

}
