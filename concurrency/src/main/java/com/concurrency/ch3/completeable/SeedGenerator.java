package com.concurrency.ch3.completeable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyu201
 * @date 2021/6/17
 */
public class SeedGenerator implements Runnable{


    private CompletableFuture<Integer> resultCommunicator;

    public SeedGenerator(CompletableFuture<Integer> completableFuture) {
        this.resultCommunicator = completableFuture;
    }

    @Override
    public void run() {
        System.out.printf("SeedGenerator: Generating seed...\n");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        int seed = (int) Math.rint(Math.random()*10);
        System.out.printf("SeedGenerator: Seed generate: %d\n",seed);
        resultCommunicator.complete(seed);
    }
}
