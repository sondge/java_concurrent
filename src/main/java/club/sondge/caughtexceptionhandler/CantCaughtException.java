package club.sondge.caughtexceptionhandler;

public class CantCaughtException implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try {
            new Thread(new CantCaughtException(), "线程1").start();
            new Thread(new CantCaughtException(), "线程2").start();
            new Thread(new CantCaughtException(), "线程3").start();
            new Thread(new CantCaughtException(), "线程4").start();
        }catch (Exception e) {
            System.out.println("caught Exception");
        }
    }
}
