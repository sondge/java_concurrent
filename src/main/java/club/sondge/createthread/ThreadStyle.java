package club.sondge.createthread;

/**
 * 采用Thread的方式创建线程
 */
public class ThreadStyle extends Thread{
    @Override
    public void run() {
        System.out.println("创建Thread风格的线程");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
