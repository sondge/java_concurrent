package club.sondge.stopthread;

public class RightUseInterruptedWithoutSleep implements Runnable {
    @Override
    public void run() {
        int num = 0;

        while (num <= Integer.MAX_VALUE / 2 && !Thread.currentThread().isInterrupted()) {
            if (num % 10000 == 0) {
                System.out.println(num + "是10000的整数倍");
            }
            num++;
        }
        System.out.println("任务结束运行");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightUseInterruptedWithoutSleep());
        thread.start();
        thread.sleep(1000);
        thread.interrupt();

    }

}
