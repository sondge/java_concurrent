package javapackage.concurrent.charpter;

import java.util.concurrent.CountDownLatch;

public class ReOrderTest {
    //初始化变量
    private static int a = 0, b = 0, c = 0, d = 0;


    public static void main(String[] args) throws InterruptedException {
        while (true) {
            a = b = c = d = 0;
            CountDownLatch countDownLatch = new CountDownLatch(1);

            Thread firstThread = new Thread(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a = 1;
                b = c;
            });

            Thread secondThread = new Thread(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                c = 1;
                d = a;
            });

            firstThread.start();
            secondThread.start();
            countDownLatch.countDown();

            firstThread.join();
            secondThread.join();

//            System.out.println(b + ":" + d);

            if (b == 0 && d == 0) {
                System.out.println("b=0 and d=0");
                break;
            }
        }
    }
}
