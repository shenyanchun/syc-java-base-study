package syc.study.javabase.mythread.thread;

import java.util.concurrent.*;

public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable is running");
            }
        };

        Callable<Integer> callable = new Callable() {
            @Override
            public Object call(){
                System.out.println("callable is running");
                return 100;
            }
        };

        FutureTask<Integer> future = new FutureTask<>(callable);

//        new Thread(future, "futureThread").start();
//        Integer i = future.get();
//        System.out.println("future result:"+i);
        System.out.println("------------------------");
        executorService.submit(future);
        Object o = future.get();
        future.isDone();
        System.out.println("executorService"+o);
    }
}
