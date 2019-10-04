package club.sondge.threadmainmethod;

public class ThreadId implements Runnable {
    @Override
    public void run() {
        System.out.println("线程Id为："+Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        Runnable runnable = new ThreadId();
        System.out.println("线程Id为："+Thread.currentThread().getId());
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
