package com.concurrency.ch2.lock;

/**
 * @author zhangyu201
 * @date 2021/6/15
 */
public class Job implements Runnable {
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a document\n",Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s: The document has been printed\n",Thread.currentThread().getName());

    }

    public static void main(String[] args) {
        System.out.printf("Running example with fair-mode=false\n");
        testPrintQueue(false);
        System.out.printf("Running example with fair-mode=true\n");
        testPrintQueue(true);
    }

    private static void testPrintQueue(boolean fairMode) {
        PrintQueue printQueue = new PrintQueue(fairMode);
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue),"Thread "+i);
        }
        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
        for (int i = 0; i < 10; i++) {
            try {
                thread[i].join();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}
