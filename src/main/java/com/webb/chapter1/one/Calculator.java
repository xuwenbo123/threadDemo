package com.webb.chapter1.one;

/**
 * @author 67345
 * @create 2017-01-03 19:02
 **/
public class Calculator implements Runnable{

    private int number;

    public Calculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {

        for (int i = 1; i < 10;i++) {
            System.out.printf("%s : %d * %d = %d\n", Thread.currentThread().getName(), number, i, i * number);
        }

    }
}
