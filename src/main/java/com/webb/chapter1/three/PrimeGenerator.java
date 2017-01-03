package com.webb.chapter1.three;

/**
 * @author 67345
 * @create 2017-01-03 19:10
 **/
public class PrimeGenerator extends Thread {

    @Override
    public void run() {
        long number = 1;
        while (true) {
            if (isPrime(number)) {
                System.out.printf("Number %d is Prime\n", number);
            }

            //判断线程是否被中断
            if (isInterrupted()) {
                System.out.printf("The Prime Generator has been Interrupted");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number) {

        if (number <= 2) {
            return true;
        }

        for (long i = 2; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }

        return true;
    }

}
