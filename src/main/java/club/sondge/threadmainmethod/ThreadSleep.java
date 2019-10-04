package club.sondge.threadmainmethod;

public class ThreadSleep implements Runnable{
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("线程"+Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("线程%s继续运行",Thread.currentThread().getName()));
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new ThreadSleep();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}
