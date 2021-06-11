package com.concurrency.ch1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyu201
 * @date 2021/6/10
 */
public class NetworkConnectionLoader implements Runnable{
    @Override
    public void run() {
        System.out.printf("Beginning network connection loading: %s\n",new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.printf("Network connection loading has finished:%s\n",new Date());


    }

    public static void main(String[] args) {
        DataSourceLoader dsLoader = new DataSourceLoader();
        Thread thread1 = new Thread(dsLoader,"DataSourceThread");
        NetworkConnectionLoader ncLoader = new NetworkConnectionLoader();
        Thread thread2 = new Thread(ncLoader,"NetworkConnectionThread");
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.printf("Main: Configuration has been loaded:%s\n",new Date());
    }
}
class DataSourceLoader implements Runnable{
    @Override
    public void run() {
        System.out.printf("Beginning data sources loading: %s\n",new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.printf("Data sources loading has finished:%s\n",new Date());


    }
}