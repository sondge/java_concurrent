package atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {

    private AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);

    @Test
    public void testSet() {
        atomicIntegerArray.set(0, 10);
        printAtomicArray();
    }

    @Test
    public void testLazySet() {
        atomicIntegerArray.lazySet(0, 20);
        printAtomicArray();
    }

    @Test
    public void testGetAndSet() {
        int result = atomicIntegerArray.getAndSet(0, 10);
        System.out.println(result);
    }

    @Test
    public void testCompareAndSet() {
        boolean result = atomicIntegerArray.compareAndSet(0, 0, 10);
        System.out.println(result);
        printAtomicArray();
    }

    @Test
    public void testWeakCompareAndSet() {
        boolean result = atomicIntegerArray.weakCompareAndSet(0, 0, 10);
        System.out.println(result);
    }

    @Test
    public void testGetAndIncrement() {
        int result = atomicIntegerArray.getAndIncrement(0);
        System.out.println(result);
    }

    @Test
    public void testGetAndDecrement() {
        atomicIntegerArray.getAndIncrement(0);
        int result = atomicIntegerArray.getAndDecrement(0);
        System.out.println(result);
        printAtomicArray();
    }

    @Test
    public void testGetAndAdd() {
        int result = atomicIntegerArray.getAndAdd(0, 100);
        System.out.println(result);
        printAtomicArray();
    }

    @Test
    public void testIncrementAndGet() {
        int result  =  atomicIntegerArray.incrementAndGet(0);
        System.out.println(result);
        printAtomicArray();
    }

    @Test
    public void testDecrementAndGet() {
        int result = atomicIntegerArray.decrementAndGet(0);
        System.out.println(result);
        printAtomicArray();
    }

    @Test
    public void testAddAndGet() {
        int result = atomicIntegerArray.addAndGet(0, 10);
        System.out.println(result);
        printAtomicArray();
    }

    private void printAtomicArray() {
        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            System.out.println(atomicIntegerArray.get(i));
        }
    }
}
