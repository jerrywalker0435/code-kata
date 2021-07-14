package com.concurrency.ch3.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhangyu201
 * @date 2021/6/15
 */
public class VideoConference implements Runnable{

    private final CountDownLatch controller;

    public VideoConference(int number) {
        this.controller = new CountDownLatch(number);
    }

    public void arrive(String name){
        System.out.printf("%s has arrived.",name);
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n",controller.getCount());
    }
    @Override
    public void run() {
        try {
            System.out.printf("VideoConference: Initialization: %d participants.\n",controller.getCount());
            controller.await();
            System.out.printf("VideoConference: All the participants have come.\n");
            System.out.printf("VideoConference: Let's start...\n");
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VideoConference conference = new VideoConference(10);
        Thread threadConference = new Thread(conference);
        threadConference.start();

        for (int i = 0; i < 10; i++) {
            Participant p = new Participant(conference,"Participant "+1);
            Thread t = new Thread(p);
            t.start();
        }
    }
}
