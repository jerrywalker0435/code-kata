package com.concurrency.ch2.syncronized.unsafe;

/**
 * @author zhangyu201
 * @date 2021/6/11
 */
public class ParkingStats {
    private long numberCars;

    private long numberMotorcycles;
    private ParkingCash cash;
    public ParkingStats(ParkingCash cash){
        this.numberCars = 0;
        this.numberMotorcycles = 0;
        this.cash = cash;
    }
    public void carComeIn(){
        numberCars++;
    }

    public void carGoOut(){
        numberCars--;
        cash.vehiclePay();
    }
    public void motoComeIn(){
        numberMotorcycles++;
    }
    public void motoGoOut(){
        numberMotorcycles--;
        cash.vehiclePay();
    }

    public long getNumberCars() {
        return numberCars;
    }

    public long getNumberMotorcycles() {
        return numberMotorcycles;
    }
}
