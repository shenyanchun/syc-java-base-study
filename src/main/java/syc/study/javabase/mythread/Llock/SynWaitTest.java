package syc.study.javabase.mythread.Llock;

import org.openjdk.jol.info.ClassLayout;
import syc.study.javabase.model.Student;
import syc.study.javabase.proxy.User;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * synchronized 测试类
 * @author syc
 */
public class SynWaitTest {
    final Object syn = new Object();

    /** 1.通过synchronized实现等待通知
     *
     */
    public void waitAndNotify(){
        Thread waitThead = new Thread(()->{
            synchronized (syn){
                System.out.println(Thread.currentThread().getName()+"等待线程开始等待");
                try {
                    syn.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"等待线程被唤醒");
            }
        },"waitThread");

        Thread notifyThread = new Thread(()->{
            synchronized (syn){
                System.out.println(Thread.currentThread().getName()+"通知线程开始执行 7s后唤醒waitThread");
                try {
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                syn.notifyAll();

            }
        },"notifyThread");
        waitThead.start();
        notifyThread.start();
    }

    /**
     * 测试线程唤醒
     */
    public void interrupted(){
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName()+"开始执行");
            while (true){
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                System.out.println(Thread.currentThread().getName()+"正在执行,当前中断状态:"+Thread.currentThread().isInterrupted());
                if(Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread().getName()+"线程接收到中断请求："+Thread.currentThread().isInterrupted());
                    Thread.interrupted();
                    break;
                }
            }
        };
        Thread thread = new Thread(runnable, "thread1");
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.interrupt();

//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
//        threadPoolExecutor.execute();

    }

    public static void main1(String[] args) {
        SynWaitTest synWaitTest = new SynWaitTest();
        // 测试synchronized实现等待通知
//        synWaitTest.waitAndNotify();
        // 测试线程唤醒
        synWaitTest.interrupted();
        System.out.println("main线程结束");
    }

    /**
     * 打印实例对象的内存布局
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Student student = new Student();
        Thread.sleep(5000);
        System.out.println("开启偏向锁："+ClassLayout.parseInstance(student).toPrintable());
        for(int i=0;i<2;i++){
            synchronized (student){
                System.out.println("开启带线程id的偏向锁："+ClassLayout.parseInstance(student).toPrintable());
            }
            System.out.println("释放偏向锁："+ClassLayout.parseInstance(student).toPrintable());
        }

    }

}
