package club.sondge.createthread.wrong;

/**
 * 匿名内部类的方式
 */
public class AnonymousInnerClassDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("这是匿名Runnable内部类的方式，创建线程");
            }
        }).start();
        new Thread(){
            @Override
            public void run() {
                System.out.println("这是匿名Thread内部类的方式，创建线程");
            }
        }.start();
    }
}
