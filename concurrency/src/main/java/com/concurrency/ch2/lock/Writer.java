package com.concurrency.ch2.lock;

import java.util.Date;

/**
 * @author zhangyu201
 * @date 2021/6/15
 */
public class Writer implements Runnable{

    private PricesInfo pricesInfo;

    public Writer(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.printf("%s: Writer: Attempt to modify the prices\n",new Date());
            pricesInfo.setPrices(Math.random()*10,Math.random()*8);
            System.out.printf("%s: Writer: Prices have been modified\n",new Date());
            try {
                Thread.sleep(2);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        PricesInfo pricesInfo = new PricesInfo();
        Reader readers[] = new Reader[5];
        Thread threadsReader[] = new Thread[5];
        for (int i = 0; i < 5; i++) {
            readers[i] = new Reader(pricesInfo);
            threadsReader[i] = new Thread(readers[i]);
        }

        Writer writer = new Writer(pricesInfo);
        Thread threadWriter = new Thread(writer);
        for (int i = 0; i < 5; i++) {
            threadsReader[i].start();
        }
        threadWriter.start();
    }
}
