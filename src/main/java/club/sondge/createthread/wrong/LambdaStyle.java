package club.sondge.createthread.wrong;

/**
 * Lambda表达式
 */
public class LambdaStyle {
    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
