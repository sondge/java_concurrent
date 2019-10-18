package javapackage.concurrent.charpter;

import java.util.Vector;

public class VectorTest implements Runnable {
    public Vector list = new Vector();

    public VectorTest() {
        list.add(10);
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(1);
        list.add(2);
    }

    @Override
    public void run() {
        System.out.println(getLast(list));
        deleteLast(list);
    }

    public Object getLast(Vector list) {
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }

    public void deleteLast(Vector list) {
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }

    public static void main(String[] args) {
        VectorTest vectorTest= new VectorTest();
        Thread thread1 = new Thread(vectorTest);
        Thread thread2 = new Thread(vectorTest);
        Thread thread5 = new Thread(vectorTest);
        Thread thread6 = new Thread(vectorTest);
        Thread thread7 = new Thread(vectorTest);
        Thread thread9 = new Thread(vectorTest);
        Thread thread8 = new Thread(vectorTest);
        Thread thread4 = new Thread(vectorTest);
        Thread thread3 = new Thread(vectorTest);
        Thread thread10 = new Thread(vectorTest);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();




    }
}
