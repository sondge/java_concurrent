package club.sondge.caughtexceptionhandler;

public class MyCaughtException implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("线程：" + t.getName() + "抛出了异常：" + e);
        e.printStackTrace();
    }
}
