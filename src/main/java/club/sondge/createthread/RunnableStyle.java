package club.sondge.createthread;

/**
 * 采用Runnable接口的方式
 */
public class RunnableStyle {
    public static void main(String[] args) {
        new Thread(new RunnableStyleCreateThread()).start();
    }

    private static class  RunnableStyleCreateThread implements Runnable{
        public void run() {
            System.out.println("这是Runnable风格创建线程的方式");
        }
    }
}
