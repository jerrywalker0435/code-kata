package com.concurrency.ch3.s3.cyclicBarrier;

/**
 * @author zhangyu201
 * @date 2021/6/15
 */
public class Results {
    private final int data[];

    public Results(int size) {
        this.data = new int[size];
    }
    public void setData(int position,int value){
        data[position]=value;
    }

    public int[] getData(){
        return data;
    }
}
