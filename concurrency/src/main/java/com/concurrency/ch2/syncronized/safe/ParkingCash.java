package com.concurrency.ch2.syncronized.safe;

/**
 * @author zhangyu201
 * @date 2021/6/11
 */
public class ParkingCash {
    private static final int cost = 2;
    private long cash;
    public ParkingCash(){
        cash = 0;
    }
    public synchronized void vehiclePay(){
        cash+=cost;
    }

    public void close(){
        System.out.printf("Closing accounting");
        long totalAmount;
        synchronized (this) {
            totalAmount = cash;
            cash = 0;
        }
        System.out.printf("The total amount is : %d",totalAmount);
    }

}


