package com.concurrency.ch3.s2.countdownlatch;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangyu201
 * @date 2021/6/15
 */
public class Participant implements Runnable{

    private VideoConference conference;

    private String name;

    public Participant(VideoConference conference, String name) {
        this.conference = conference;
        this.name = name;
    }


    @Override
    public void run() {
        long duration = (long) (Math.random()*10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        conference.arrive(name);

    }
}
