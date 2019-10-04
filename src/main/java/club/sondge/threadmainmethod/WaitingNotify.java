package club.sondge.threadmainmethod;

public class WaitingNotify {
    private static Object object = new Object();
    static class A extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("获取锁" + Thread.currentThread().getName());
                try {
                    object.wait();
                    System.out.println("继续执行锁" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class B extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("获取锁" + Thread.currentThread().getName());
                object.notify();
                System.out.println("释放锁成功");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        B b = new B();
        a.start();

        Thread.sleep(1000);
        b.start();
    }
}
