package club.sondge.synchronizedpackage;

public class SynchronizedSameMethod {
    int i = 0;

    private synchronized void method1() {
        System.out.println("这是 method1 方法");
        if (i == 0) {
            i++;
            method1();
        }
    }

    public static void main(String[] args) {
        SynchronizedSameMethod synchronizedSameMethod = new SynchronizedSameMethod();
        synchronizedSameMethod.method1();
    }
}
