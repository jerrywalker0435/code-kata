package com.concurrency.ch3.s3.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier allows the synchronization of two or more threads at a determined point.
 *   This class is initialized with an integer number,which is the number of threads that will be synchronized at a
 * determined point.When one of these threads arrives at the determined point,it calls the await() method to wait for the
 * other thread.When the thread call this method,The CyclicBarrier class blocks the thread that is sleeping until the
 * other threads arrive.When the last thread calls the await() method the CyclicBarrier object,it wakes up all the threads
 * that waiting and continues with its job.
 */
public class Grouper implements Runnable{
    private final Results results;

    public Grouper(Results results) {
        this.results = results;
    }

    @Override
    public void run() {
        int finalResult = 0;
        System.out.printf("Grouper: Processing results...\n");
        int data[] = results.getData();
        for (int number:data){
            finalResult += number;
        }
        System.out.printf("Grouper: Total result: %d\n",finalResult);
    }

    public static void main(String[] args) {
        final int ROWS = 10000;
        final int NUMBERS = 1000;
        final int SEARCH = 5;
        final int PARTICIPANTS = 5;
        final int LINES_PARTICIPANT=2000;
        MatrixMock mock = new MatrixMock(ROWS,NUMBERS,SEARCH);
        Results results = new Results(ROWS);
        Grouper grouper = new Grouper(results);
        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS,grouper);
        Searcher searchers[] = new Searcher[PARTICIPANTS];
        for (int i = 0; i < PARTICIPANTS; i++) {
            searchers[i]= new Searcher(i*LINES_PARTICIPANT,(i*LINES_PARTICIPANT)+LINES_PARTICIPANT,
                    mock,results,5,barrier);
            Thread thread = new Thread(searchers[i]);
            thread.start();
        }
        System.out.printf("Main: The main thread has finished.\n");
    }
}
