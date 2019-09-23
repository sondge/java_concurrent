package club.sondge.createthread.wrong;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 使用定时器打印时间
 */
public class DemoTimerTask {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        },1000,1000);
    }
}
