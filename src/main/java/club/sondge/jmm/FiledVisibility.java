package club.sondge.jmm;

public class FiledVisibility {
    static int a = 1, b = 3;

    private static void change() {
        a = 10;
        b = a;
    }

    private static void print() {
        System.out.println("a = " + a + ";b = " + b);
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                change();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                print();
            }
        });
        thread1.start();
        thread2.start();
    }
}
