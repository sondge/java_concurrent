package club.sondge.threadmainmethod;

import java.util.Date;
import java.util.LinkedList;

public class ProduceAndCustomer {

    public static void main(String[] args) {
        Storage storage = new Storage();
        Produce produce = new Produce(storage);
        Consumer consumer = new Consumer(storage);

        Thread thread1 = new Thread(produce);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();
    }


    static class Produce implements Runnable {
        private Storage storage;

        Produce(Storage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                storage.put();
            }
        }
    }

    static class Storage {
        private static final int MAX = 10;
        private LinkedList linkedList;

        public LinkedList getLinkedList() {
            return linkedList;
        }

        Storage() {
            linkedList = new LinkedList();
        }


        public synchronized void put() {
            if (linkedList.size() >= Storage.MAX) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            linkedList.add(new Date());
            System.out.println("消息队列的大小为" + linkedList.size());
            notify();
        }

        public synchronized void get() {
            if (linkedList.size() <= 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(String.format("消费的元素为%s，剩余的大小%d", linkedList.poll(), linkedList.size()));
                notify();
            }
        }
    }

    static class Consumer implements Runnable {
        private Storage storage;

        Consumer(Storage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                storage.get();
            }
        }
    }
}

