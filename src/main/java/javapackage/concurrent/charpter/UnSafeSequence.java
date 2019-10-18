package javapackage.concurrent.charpter;

public class UnSafeSequence implements Runnable {
    private static int value;

    public static int getValue() {
        return ++value;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new UnSafeSequence();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(value);
    }

    @Override
    public void run() {
        getValue();
    }
}
