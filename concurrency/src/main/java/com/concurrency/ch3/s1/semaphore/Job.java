package com.concurrency.ch3.s1.semaphore;

/**
 * Semaphore is a counter that protects access to one or more shared resources.
 *   When a thread wants to access one of the shared resources,it must first acquire the semaphore.If the internal counter
 * of the semaphore is greater than 0,the semaphore decrements the counter and allows access to the shared resource.A counter
 * bigger than 0 implies that there are free resources that can be used,so the thread can access and use one of them.
 *   Otherwise,if the counter is 0,the semaphore puts the thread to sleep until the counter is greater than 0. A value of
 * 0 int the counter means all the shared resources are used by other threads,so the thread that wants to use one of them
 * must wait until one is free.
 *   When the thread has finished using the shared resource,it must release the semaphore so that another thread can access
 * the resource.This operation increase the internal counter of the semaphore.
 *
 */
public class Job implements Runnable{

    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a job\n",Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s: The document has been printed\n",Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread threads[] = new Thread[12];
        for (int i = 0; i < threads.length; i++) {
           threads[i] = new Thread(new Job(printQueue),"Thread"+i);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
