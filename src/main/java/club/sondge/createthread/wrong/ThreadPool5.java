package club.sondge.createthread.wrong;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 采用线程池的方式创建线程
 */
public class ThreadPool5 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }
}
