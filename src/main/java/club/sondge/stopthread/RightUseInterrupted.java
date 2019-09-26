package club.sondge.stopthread;

public class RightUseInterrupted {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int num = 0;
                try {

                    while (num <= 1000000) {
                        if (num % 100 == 0) {
                            System.out.println(num + "是1000的整数倍");
                        }
                        num++;
                        Thread.sleep(100);
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

    }
}