package club.sondge.startthread;

public class CantStartTwice {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        thread.start();

        thread.start();
    }
}