package club.sondge.stopthread;

public class RightWayRestoreInterrupt implements Runnable {
    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()) {
            try {
                System.out.println("开始打印线程");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("终端线程");
                System.out.println("中断线程");
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayRestoreInterrupt());
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
