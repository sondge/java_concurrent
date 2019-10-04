package club.sondge.caughtexceptionhandler;

public class MyUncaughtExceptionHandler implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyCaughtException());
        new Thread(new MyUncaughtExceptionHandler(), "线程1").start();
        new Thread(new MyUncaughtExceptionHandler(), "线程2").start();
        new Thread(new MyUncaughtExceptionHandler(), "线程3").start();
        new Thread(new MyUncaughtExceptionHandler(), "线程4").start();
    }
}
