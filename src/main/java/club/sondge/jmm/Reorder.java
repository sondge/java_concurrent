package club.sondge.jmm;

import java.util.concurrent.CountDownLatch;

public class Reorder {
    static int x = 0, a = 0, b = 0, y = 0;

    public static void main(String[] args) throws InterruptedException {
        for (;;) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a = 3;
                    x = b;
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b = 3;
                    y = a;
                }
            });

            thread1.start();
            thread2.start();
            countDownLatch.countDown();
            thread1.join();
            thread2.join();
            System.out.println("x = " + x + ";y = " + y);
            if (x == 3 && y == 3) {
                break;
            }
        }
    }
}
