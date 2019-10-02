package club.sondge.synchronizedpackage;

public class SynchronizedObject2 implements Runnable {
    static SynchronizedObject2 syncchronizedObject =  new SynchronizedObject2();
    @Override
    public void run() {
       executeMethod();
    }

    private synchronized void executeMethod() {
        System.out.println("开启了线程:"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("关闭了线程:"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(syncchronizedObject);
        Thread thread2 = new Thread(syncchronizedObject);

        thread1.start();
        thread2.start();

        while (thread1.isAlive() || thread2.isAlive()) {

        }

        System.out.println("执行结束");
    }
}
