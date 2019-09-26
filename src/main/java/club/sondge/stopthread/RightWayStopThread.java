package club.sondge.stopthread;

public class RightWayStopThread implements Runnable {
    @Override
    public void run() {
        try {
            threadMethod();
        System.out.println(123);
        } catch (InterruptedException e) {
            System.out.println("停止成功");
            e.printStackTrace();
        }
    }

    private void threadMethod() throws InterruptedException {
        System.out.println("开始打印线程");
            Thread.sleep(2000);

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThread());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

}
