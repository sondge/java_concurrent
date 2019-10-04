package club.sondge.threadmainmethod;

public class JoinImpl implements Runnable {
    @Override
    public void run() {
        System.out.println("线程" + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("线程%s继续运行", Thread.currentThread().getName()));
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Join();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        synchronized (thread1) {
            thread1.wait();
        }
        System.out.println("全部子线程结束运行");
    }
}