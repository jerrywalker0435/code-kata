package com.concurrency.ch2.syncronized.safe;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangyu201
 * @date 2021/6/11
 */
public class Sensor implements Runnable{
    private ParkingStats stats;

    public Sensor(ParkingStats stats) {
        this.stats = stats;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            stats.carComeIn();
            stats.carComeIn();
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            stats.motoComeIn();

            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            stats.motoGoOut();
            stats.carGoOut();
            stats.carGoOut();

        }
    }

    public static void main(String[] args) {
        ParkingCash cash = new ParkingCash();
        ParkingStats stats = new ParkingStats(cash);
        System.out.printf("Parking Simulator with cpu core:%d\n",Runtime.getRuntime().availableProcessors());
        int numberSensors = 2 * Runtime.getRuntime().availableProcessors();
        Thread threads[] = new Thread[numberSensors];
        for (int i = 0; i < numberSensors; i++) {
            Sensor sensor = new Sensor(stats);
            Thread thread = new Thread(sensor);
            thread.start();
            threads[i] = thread;
        }
        for (int i = 0; i < numberSensors; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        System.out.printf("Number of Cars:%d\n",stats.getNumberCars());
        System.out.printf("Number of Motorcycles:%d\n",stats.getNumberMotorcycles());
        cash.close();
    }
}
