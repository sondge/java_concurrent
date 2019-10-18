package atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    AtomicInteger atomicInteger = new AtomicInteger(10);

    @Test
    public void testAddAndGet() {
        int result = atomicInteger.addAndGet(10);
        // 预测结果为: 20
        System.out.println(result);
    }

    @Test
    public void testCompareAndSet() {
        int a = 100;
        int b = 20;
        boolean isEqual = atomicInteger.compareAndSet(a, b);
        if (isEqual) {
            System.out.println("a 与 b 相等");
        } else {
            System.out.println("a 与 b 不相等");
        }
        System.out.println(atomicInteger.get());
    }

    @Test
    public void testDecrementAndGet() {
        int result = atomicInteger.decrementAndGet();
        // 预测结果为：9
        System.out.println(result);
    }

    @Test
    public void testGet() {
        int result = atomicInteger.get();
        System.out.println(result);
    }

    @Test
    public void testGetAndAdd() {
        int result = atomicInteger.getAndAdd(10);
        //预测结果 10
        System.out.println(result);
    }

    @Test
    public void testGetAndDecrement() {
        int result = atomicInteger.getAndDecrement();
        //预测结果 10
        System.out.println(result);
    }

    @Test
    public void tetGetAndIncrement() {
        int result = atomicInteger.getAndIncrement();
        //预测结果 10
        System.out.println(result);
    }

    @Test
    public void testGetAndSet() {
        int result = atomicInteger.getAndSet(20);
        //预测结果 10
        System.out.println(result);
    }

    @Test
    public void testIncrementAndGet() {
        int result = atomicInteger.incrementAndGet();
        //预测结果 11
        System.out.println(result);
    }

    @Test
    public void testLazySet() {
        atomicInteger.lazySet(20);
        //预测结果为：20
        System.out.println(atomicInteger.get());
    }

    @Test
    public void testSet() {
        atomicInteger.set(20);
        //预测结果为：20
        System.out.println(atomicInteger.get());
    }

    @Test
    public void testWeakCompareAndSet() {
        Thread thread = new Thread(() -> {

            for (int i = 0; i <100; i++) {

            }
        });
    }
}
