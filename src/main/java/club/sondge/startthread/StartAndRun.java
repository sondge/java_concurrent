package club.sondge.startthread;

public class StartAndRun {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.run();

        thread.start();
    }
}