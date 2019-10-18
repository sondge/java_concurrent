package club.sondge.threadsafe;

public class MultiThreadsError2 {
    static Point point;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new PointMaker()).start();
//        Thread.sleep(10);
        Thread.sleep(110);
        if (point!=null) {
            System.out.println(point);
        }
    }
}

class Point {
    private static int x, y;

    public Point(int x, int y) throws InterruptedException {
        this.x = x;
        MultiThreadsError2.point = this;
        Thread.sleep(100);
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}

class PointMaker implements Runnable {

    @Override
    public void run() {
        try {
            new Point(1,1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
