package club.sondge.synchronizedpackage;

public class SynchronizedMothodAndNormalMethod implements Runnable {
    static SynchronizedClassStaticMethod synchronizedClassStaticMethod = new SynchronizedClassStaticMethod();

    @Override
    public void run() {
        if ("线程1".equals(Thread.currentThread().getName())) {
            method1();
        }
        else {
            method2();
        }
    }

    private synchronized void method1() {
        System.out.println("开启了线程:" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("关闭了线程:" + Thread.currentThread().getName());
    }

    private void method2() {
        System.out.println("开启了线程:" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("关闭了线程:" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(synchronizedClassStaticMethod);
        thread1.setName("线程1");
        Thread thread2 = new Thread(synchronizedClassStaticMethod);
        thread2.setName("线程2");
        thread1.start();
        thread2.start();

        while (thread1.isAlive() || thread2.isAlive()) {

        }

        System.out.println("执行结束");
    }
}
