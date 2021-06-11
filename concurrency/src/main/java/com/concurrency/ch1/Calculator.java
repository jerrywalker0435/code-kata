package com.concurrency.ch1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zhangyu201
 * @date 2021/6/10
 */
public class Calculator implements Runnable {
    public void run() {
        long current = 1L;
        long max = 20000L;
        long numPrimes = 0;
        System.out.printf("Thread '%s' Start\n",Thread.currentThread().getName());
        while (current<max){
            if(isPrime(current)){
                numPrimes++;
            }
            current++;
        }
        System.out.printf("Thread '%s' End,Number of Primes:%d\n",Thread.currentThread().getName(),numPrimes);

    }

    private boolean isPrime(long number) {
        if (number<=2) {
            return true;
        }
        for (int i = 2; i < number ; i++) {
            if ((number%i)==0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.printf("Minimum Priority:%s\n",Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority:%s\n",Thread.NORM_PRIORITY);
        System.out.printf("Maximum Priority:%s\n",Thread.MAX_PRIORITY);

        Thread threads[];
        Thread.State status[];
        threads = new Thread[10];
        status = new Thread.State[10];
        for (int i = 0; i <10; i++) {
            threads[i] = new Thread(new Calculator());
            if((i%2)==0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("My Thread "+ i);
        }

        try(FileWriter fileWriter = new FileWriter("/Users/jerry.zhang/WorkSpace/practice/code-kata/log.txt")) {
            PrintWriter pw = new PrintWriter(fileWriter);
            for (int i = 0; i < 10; i++) {
                pw.println("Main: Status of Thread "+ i + ": "+threads[i].getState());
                status[i] = threads[i].getState();
            }
            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }
            boolean finish = false;
            while (!finish){
                for (int i = 0; i < 10; i++) {
                    if(threads[i].getState()!=status[i]){
                        writeThreadInfo(pw,threads[i],status[i]);
                        status[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState()== Thread.State.TERMINATED);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } ;

    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State status) {
        pw.printf("Main: Id %d - %s\n",thread.getId(),thread.getName());
        pw.printf("Main: Priority %d\n",thread.getPriority());
        pw.printf("Main: Old State %s\n",status);
        pw.printf("Main: New State %s\n",thread.getState());
        pw.printf("Main: *******************************\n");
    }
}
