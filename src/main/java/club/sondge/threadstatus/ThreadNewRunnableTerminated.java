package club.sondge.threadstatus;

public class ThreadNewRunnableTerminated implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadNewRunnableTerminated());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        Thread.sleep(10);
        System.out.println(thread.getState());
        thread.join();
        System.out.println(thread.getState());
    }
}
