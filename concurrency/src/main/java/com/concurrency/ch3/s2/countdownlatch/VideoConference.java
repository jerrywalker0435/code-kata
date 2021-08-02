package com.concurrency.ch3.s2.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch allows one or more threads to wait until a set of operations are made.
 *   This class is initialized with an integer number,which is the number of operations the threads are going to wait for.
 * When a thread wants to wait for the execution of these operations,it uses the await() method.This method puts the thread
 * to sleep until the operations are completed.When one of these operations finishes,it uses the countDown() method to
 * decrement the internal counter of the CountDownLatch class.When the counter arrives at 0,the class wakes up all the
 * threads that were sleeping in the await() method.
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
