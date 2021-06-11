package com.concurrency.ch1;

import java.util.Random;

/**
 * @author zhangyu201
 * @date 2021/6/11
 */
public class MyThreadGroup extends ThreadGroup{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("The Thread %s has throw an exception\n",t.getId());
        e.printStackTrace(System.out);
        System.out.printf("Terminating the rest of threads\n");
        interrupt();
    }

    public MyThreadGroup(String name) {
        super(name);
    }

    public static void main(String[] args) {
        int numberOfThreads = 2 * Runtime.getRuntime().availableProcessors();
        MyThreadGroup myThreadGroup = new MyThreadGroup("MyThreadGroup");
        GroupTask task = new GroupTask();
        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(myThreadGroup,task);
            thread.start();
        }

        System.out.printf("Number of Threads:%d\n",myThreadGroup.activeCount());
        System.out.printf("Information about thread group\n");
        myThreadGroup.list();

        Thread threads[] = new Thread[myThreadGroup.activeCount()];
        myThreadGroup.enumerate(threads);
        for (int i = 0; i < myThreadGroup.activeCount(); i++) {
            System.out.printf("Thread: %s:%s\n",threads[i].getName(),threads[i].getState());
        }
    }
}
class GroupTask implements Runnable{

    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while (true) {
            result = 1000/(int)(random.nextDouble()*1000000000);

            if(Thread.currentThread().isInterrupted()){
                System.out.printf("%d: interrupted\n",Thread.currentThread().getId());
                return;
            }
        }
    }
}