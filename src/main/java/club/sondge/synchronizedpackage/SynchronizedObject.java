package club.sondge.synchronizedpackage;

public class SynchronizedObject implements Runnable {
    static SynchronizedObject synchronizedObject =  new SynchronizedObject();
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("开启了线程:"+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("关闭了线程:"+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(synchronizedObject);
        Thread thread2 = new Thread(synchronizedObject);

        thread1.start();
        thread2.start();

        while (thread1.isAlive() || thread2.isAlive()) {

        }

        System.out.println("执行结束");
    }
}
