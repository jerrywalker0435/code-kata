package com.concurrency.ch1;

/**
 * @author zhangyu201
 * @date 2021/6/11
 */
public class Task implements Runnable {
    @Override
    public void run() {
        Integer num = Integer.parseInt("TT");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }

}
class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("An Exception has been captured\n");
        System.out.printf("Thread: %d\n",t.getId());
        System.out.printf("Exception: %s:%s\n",e.getClass().getName(),e.getMessage());
        System.out.printf("Stack Trace:\n");
        e.printStackTrace(System.out);
        System.out.printf("Thread Status:%s\n",t.getState());
    }
}

