package club.sondge.threadstatus;

public class ThreadBlockedWaitingTimedWaiting implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            try {
                Thread.sleep(2000);
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadBlockedWaitingTimedWaiting threadBlockedWaitingTimedWaiting = new ThreadBlockedWaitingTimedWaiting();
        Thread thread1 = new Thread(threadBlockedWaitingTimedWaiting);
        thread1.start();
        Thread thread2 = new Thread(threadBlockedWaitingTimedWaiting);
        thread2.start();
        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
        Thread.sleep(2100);
        System.out.println(thread1.getState());
    }
}
