package com.concurrency.ch2.condition.lock;

import java.util.Random;

/**
 * @author zhangyu201
 * @date 2021/6/15
 */
public class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.hasPendingLines()){
            String line = buffer.get();
            processLine(line);
        }
    }

    private void processLine(String line) {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(100));
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileMock mock = new FileMock(100,10);
        Buffer buffer = new Buffer(20);
        Producer producer = new Producer(mock,buffer);
        Thread producerThread = new Thread(producer,"Producer");

        Consumer consumers[] = new Consumer[3];
        Thread consumersThread[] = new Thread[3];

        for (int i = 0; i < 3; i++) {
            consumers[i] = new Consumer(buffer);
            consumersThread[i] = new Thread(consumers[i],"Consumer "+ i);
        }

        producerThread.start();
        for (int i = 0; i < 3; i++) {
            consumersThread[i].start();
        }
    }
}
