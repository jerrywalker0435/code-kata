package com.concurrency.ch1;

/**
 * @author zhangyu201
 * @date 2021/6/10
 */
public class PrimeGenerator extends Thread{
    @Override
    public void run() {
        long number = 1L;
        while (true){
            if(isPrime(number)){
                System.out.printf("Prime number %d\n",number);
            }
            if(isInterrupted()){
                System.out.printf("The Prime Generator has been interrupted");
                return;
            }
            number++;
        }

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
        Thread task = new PrimeGenerator();
        task.start();
        try {
            Thread.sleep(5000);
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }
        task.interrupt();
        System.out.printf("Main: Status of the Thread: %s\n",task.getState());
        System.out.printf("Main: isInterrupted: %s\n",task.isInterrupted());
        System.out.printf("Main: isAlive: %s\n",task.isAlive());
    }
}
