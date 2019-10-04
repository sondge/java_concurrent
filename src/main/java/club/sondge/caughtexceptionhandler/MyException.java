package club.sondge.caughtexceptionhandler;

public class MyException implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        new Thread(new MyException()).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
