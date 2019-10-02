package club.sondge.synchronizedpackage;

public class SynchronizedClassStaticMethod implements Runnable {
    static SynchronizedClassStaticMethod synchronizedClassStaticMethod1 = new SynchronizedClassStaticMethod();
    static SynchronizedClassStaticMethod synchronizesClassStaticMethod2 = new SynchronizedClassStaticMethod();
    @Override
    public void run() {
        staticMethod();
    }


    private static synchronized void staticMethod() {
        System.out.println("开启了线程:" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("关闭了线程:" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(synchronizedClassStaticMethod1);
        Thread thread2 = new Thread(synchronizesClassStaticMethod2);

        thread1.start();
        thread2.start();

        while (thread1.isAlive() || thread2.isAlive()) {

        }

        System.out.println("执行结束");
    }
}
