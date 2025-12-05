package syc.study.javabase.mythread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * cas只是一个cpu层面的操作，只会返回执行成功或者失败
 * 自选是java中的逻辑，可以看AtomicInteger类的方法，里面都有do while循环，这是直到cas返回true才会退出循环（这期间会不停获取原子类最新的值作为期望值传进去）
 * 所以在使用这些原子类的时候要点进去看一下，如果实在竞争很激烈的情况下，用原子类直到成功才退出的话就会有大量的线程在那空转，所以在竞争很大的情况下最好不要用原子类，用一些空间换时间的同步方式比如LongAdder类
 * 。jvm的重量级锁用cas是能够自适应自旋次数的
 */
public class Cas {
    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger(5);
        a.addAndGet(1);
        System.out.println(a.get());
        a.incrementAndGet();
        System.out.println(a.get());

    }
}
