package club.sondge.stopthread.volatiledemo;

public class WoryWayCantStopThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.printf("连队%d开始发枪%n", i);
            for (int j = 0; j < 100; j++) {
                System.out.printf("第%d可以领枪%n", j);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WoryWayCantStopThread woryWayCantStopThread = new WoryWayCantStopThread();
        Thread thread = new Thread(woryWayCantStopThread);
        thread.start();
        Thread.sleep(0x3e8);
        thread.stop();
    }
}
