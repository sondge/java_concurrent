package club.sondge.synchronizedpackage;

public class SynchronizedDifferentMethod {
    private synchronized void method1() {
        System.out.println("这是方法1");
        method2();
    }

    private synchronized void method2() {
        System.out.println("这是方法2");
    }

    public static void main(String[] args) {
        SynchronizedDifferentMethod synchronizedDifferentMethod = new SynchronizedDifferentMethod();
        synchronizedDifferentMethod.method1();
    }

}
