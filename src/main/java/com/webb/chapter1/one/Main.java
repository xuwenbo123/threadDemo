package com.webb.chapter1.one;

/**
 * 创建一个线程
 *
 * @author 67345
 * @create 2017-01-03 19:04
 **/
public class Main {

    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }

    }

}
