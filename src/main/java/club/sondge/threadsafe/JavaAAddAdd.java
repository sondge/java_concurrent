package club.sondge.threadsafe;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class JavaAAddAdd implements Runnable {
    private Object object = new Object();
    static int count = 0;
    boolean index[] = new boolean[1000000];
    static AtomicInteger atomicInteger = new AtomicInteger();
    static AtomicInteger wrongNum = new AtomicInteger();
    static volatile CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);
    static volatile CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            index[0] = true;
            try {
                cyclicBarrier2.reset();
                cyclicBarrier1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            count++;
            try {
                cyclicBarrier1.reset();
                cyclicBarrier2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            atomicInteger.incrementAndGet();
            synchronized (object) {
                if (index[count] && index[count-1]) {
                    System.out.println("错误的为:" + count);
                    wrongNum.incrementAndGet();
                }
                index[count] = true;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JavaAAddAdd aAddAdd = new JavaAAddAdd();
        Thread thread1 = new Thread(aAddAdd);
        Thread thread2 = new Thread(aAddAdd);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("a++后的数为：" + count);
        System.out.println("a++后的数应该为：" + atomicInteger.get());
        System.out.println("a++后的数错误次数为：" + wrongNum.get());

    }
}
