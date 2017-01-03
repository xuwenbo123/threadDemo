package com.webb.chapter1.three;

/**
 * 线程的中断
 *  interrupted() 会设置成false
 *  isInterrupted() 判断线程是否被中断
 *
 * @author 67345
 * @create 2017-01-03 19:14
 **/
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new PrimeGenerator();
        thread.start();

        Thread.sleep(1000);

        thread.interrupt();
    }

}
