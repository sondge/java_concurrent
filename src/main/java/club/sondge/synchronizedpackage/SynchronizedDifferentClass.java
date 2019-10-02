package club.sondge.synchronizedpackage;

public class SynchronizedDifferentClass {
    public synchronized void method1() {
        System.out.println("我是SynchronizedDifferentClass中的方法");
    }
}

class SynchronizedDifferent2 {
    public synchronized  void method() {
        System.out.println("我是SynchronizedDifferent2中的方法");
        SynchronizedDifferentClass synchronizedDifferentClass = new SynchronizedDifferentClass();
        synchronizedDifferentClass.method1();
    }

    public static void main(String[] args) {
        SynchronizedDifferent2 synchronizedDifferent2 = new SynchronizedDifferent2();
        synchronizedDifferent2.method();
    }
}
