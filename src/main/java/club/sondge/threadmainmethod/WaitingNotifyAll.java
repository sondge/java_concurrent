package club.sondge.threadmainmethod;

public class WaitingNotifyAll implements Runnable {
    static Object object = new Object();
    @Override
    public void run() {
        synchronized (object) {
            System.out.printf("线程%s获取了锁%n", Thread.currentThread().getName());
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("线程%s继续执行了锁%n", Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new WaitingNotifyAll();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.printf("线程%s获取了锁%n", Thread.currentThread().getName());
                    object.notifyAll();
                    System.out.printf("线程%s获取了释放了锁%n", Thread.currentThread().getName());
                }
            }
        });

        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        thread3.start();
    }
}
