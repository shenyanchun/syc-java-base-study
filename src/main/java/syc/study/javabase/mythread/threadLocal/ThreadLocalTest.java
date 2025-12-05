package syc.study.javabase.mythread.threadLocal;

public class ThreadLocalTest {

    private static  ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        for(int i=0;i<=10;i++){
            int finalI = i;
            new Thread(()->{
                Thread thread = Thread.currentThread();
                threadLocal.set(finalI);
                System.out.println(Thread.currentThread().getName()+"线程获取的threadLocal:"+threadLocal.get());
            },"thread"+i).start();
        }
    }
}
