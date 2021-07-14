package com.concurrency.ch3.semaphore;

/**
 * @author zhangyu201
 * @date 2021/6/15
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
