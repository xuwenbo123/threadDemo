package com.webb.chapter1.two;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * 2.获取和设置线程信息
 *
 * ID：每个线程的标识
 * Name：线程的名称
 * Priority：线程对象的优先级 优先级在1-10之间 1是最低级 10是最高级
 * Status：线程的状态 在Java中，线程只能有这6种中的一种状态： new, runnable, blocked, waiting, time waiting, 或 terminated.
 **/
public class Main {

    public static void main(String[] args) {

        Thread threads[] = new Thread[10];
        Thread.State status[] = new Thread.State[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator(i));

            if (( i % 2) == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread " + i);
        }

        try(FileWriter file = new FileWriter("E:\\logs\\log.txt"); PrintWriter printWriter = new PrintWriter(file)) {

            //将线程状态写入文档
            for (int i = 0; i < 10; i++) {
                printWriter.println("Main : Status of Thread" + i + " : " + threads[i].getState());
                status[i] = threads[i].getState();
            }

            //开始执行线程
            for (int i = 0; i < 10; i ++) {
                threads[i].start();
            }

            boolean finish = false;

            for (int i = 0; i < 10; i++) {
                writeThreadInfo(printWriter, threads[i], status[i]);
                status[i] = threads[i].getState();
            }

            finish = true;
            for (int i = 0; i < 10; i++) {
                finish = finish && (status[i] == Thread.State.TERMINATED);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * ID：每个线程的标识
     * Name：线程的名称
     * Priority：线程对象的优先级
     * Status：线程的状态
     */
    private static void writeThreadInfo(PrintWriter printWriter, Thread thread, Thread.State statu) {
        printWriter.printf("Main : Id %d - %s\r\n", thread.getId(), thread.getName());
        printWriter.printf("Main : Priority: %d\r\n", thread.getPriority());
        printWriter.printf("Main : Old State: %s\r\n", statu);
        printWriter.printf("Main : New State: %s\r\n", thread.getState());
        printWriter.printf("Main : ******************************\r\n");
    }
}
