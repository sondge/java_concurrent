package club.sondge.stopthread.volatiledemo;

public class WrongWayCanStopThread implements Runnable {
    private volatile boolean flag = false;

    @Override
    public void run() {
        int num = 0;
        while (num < 100000 && !flag) {
            System.out.println(num);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WrongWayCanStopThread wrongWayCanStopThread = new WrongWayCanStopThread();
        Thread thread = new Thread(wrongWayCanStopThread);
        thread.start();
        Thread.sleep(5000);
        wrongWayCanStopThread.flag = true;
    }
}
