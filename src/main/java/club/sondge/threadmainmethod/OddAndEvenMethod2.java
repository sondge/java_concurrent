package club.sondge.threadmainmethod;


public class OddAndEvenMethod2 implements Runnable {
    static Object object = new Object();
    private static int count = 0;
    @Override
    public void run() {
        while (count <= 100) {
            synchronized (object) {
                System.out.println("数：" + count);
                count++;
                object.notify();
                if (count <= 100 ) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new OddAndEvenMethod2();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
    }
}
