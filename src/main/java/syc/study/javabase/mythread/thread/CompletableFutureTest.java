package syc.study.javabase.mythread.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture.runAsync(()->{
            System.out.println("runAsync");
        });
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            Integer i = 100;
            System.out.println("one 执行:"+i);
            return i;
        });


    }
}
