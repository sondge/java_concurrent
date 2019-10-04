package club.sondge.threadmainmethod;

public class OddAndEven {
    static Object object1 = new Object();

    private static int count = 0;
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 100) {
                    synchronized (object1) {
                        if (count % 2 == 0) {
                            System.out.println("------偶数:" + count);
                            count++;
                        }
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (object1) {
                        if (count % 2 == 1) {
                            System.out.println("******奇数:" + count);
                            count++;
                        }
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
