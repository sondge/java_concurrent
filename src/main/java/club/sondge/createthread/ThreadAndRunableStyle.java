package club.sondge.createthread;

public class ThreadAndRunableStyle {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是Runnable接口的方式创建线程");
            }
        }){
            @Override
            public void run() {
                System.out.println("这是采用Thread的方式创建线程");
            }
        }.start();
    }
}
