package com.concurrency.ch1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyu201
 * @date 2021/6/11
 */
public class UnsafeTask implements Runnable{
    private Date startDate;
    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("Starting Thread: %s : %s\n",Thread.currentThread().getId(),startDate);
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.printf("Thread finished: %s : %s\n",Thread.currentThread().getId(),startDate);
    }

    public static void main(String[] args) {
        UnsafeTask unsafeTask = new UnsafeTask();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(unsafeTask);
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}
