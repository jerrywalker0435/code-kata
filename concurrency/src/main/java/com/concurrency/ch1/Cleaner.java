package com.concurrency.ch1;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author zhangyu201
 * @date 2021/6/10
 */
public class Cleaner extends Thread {

    private Deque<Event> deque;

    public Cleaner(Deque<Event> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true){
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        long difference;
        boolean delete;
        if (deque.size() == 0) {
            return;
        }
        delete = false;
        do{
            Event e = deque.getLast();
            difference = date.getTime() - e.getDate().getTime();
            if (difference>10000) {
                System.out.printf("Cleaner:%s\n",e.getEvent());
                deque.removeLast();
                delete = true;
            }
        }while (difference>10000);

        if (delete) {
            System.out.printf("Cleaner: Size of the queue:%d\n",deque.size());
        }


    }

    public static void main(String[] args) {
        Deque<Event>  deque = new ConcurrentLinkedDeque<>();
        WriterTask writer = new WriterTask(deque);
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            Thread thread = new Thread(writer);
            thread.start();
        }
        Cleaner cleaner = new Cleaner(deque);
        cleaner.start();
    }
}
