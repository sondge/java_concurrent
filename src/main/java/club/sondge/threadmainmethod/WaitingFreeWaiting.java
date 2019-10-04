package club.sondge.threadmainmethod;

public class WaitingFreeWaiting implements Runnable {
    static Object object1 = new Object();
    static Object object2 = new Object();
    @Override
    public void run() {
        synchronized (object1) {
            System.out.println("线程" + Thread.currentThread().getName() + "得到第一把锁");
            synchronized (object2) {
                System.out.println("线程" + Thread.currentThread().getName() + "得到第二把锁");
                try {
                    object1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "释放第一把锁");
            }
        }
    }

    public static void main(String[] args) {
        WaitingFreeWaiting waitingFreeWaiting = new WaitingFreeWaiting();
        Thread thread1 = new Thread(waitingFreeWaiting);
        Thread thread2 = new Thread(waitingFreeWaiting);

        thread1.start();
        thread2.start();
    }
}
