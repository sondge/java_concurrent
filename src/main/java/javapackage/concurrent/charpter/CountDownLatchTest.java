package javapackage.concurrent.charpter;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest implements Runnable {
    public long timeTask(int nThread, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThread);

        for (int i = 0; i < nThread; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    endGate.countDown();
                }
            };
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();

        return end - start;
    }

    @Override
    public void run() {
        System.out.println("123456789");
    }

    public static void main(String[] args) {
        CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
        try {
            System.out.println("花费时间为：" + countDownLatchTest.timeTask(100, countDownLatchTest));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
