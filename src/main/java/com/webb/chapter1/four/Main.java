package com.webb.chapter1.four;

/**
 * 操作线程的中断机制
 *
 * @author 67345
 * @create 2017-01-03 19:30
 **/
public class Main {

    public static void main(String[] args) throws InterruptedException {
        FileSearch fileSearch = new FileSearch("E:\\logs", "log.txt");
        Thread thread = new Thread(fileSearch);
        thread.start();

        //TimeUnit.SECONDS.sleep(1);

        Thread.sleep(1);

        thread.interrupt();
    }
}
