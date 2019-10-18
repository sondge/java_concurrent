package javapackage.concurrent.charpter;

public class SafeSequence implements Runnable {
    @Override
    public void run() {
        getNextValue();
    }

    private static int nextValue;

    public static int getNextValue() {
        return ++nextValue;
    }
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new SafeSequence();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(getNextValue());
    }

}
