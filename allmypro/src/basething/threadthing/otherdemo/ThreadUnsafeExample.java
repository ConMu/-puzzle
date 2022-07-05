package basething.threadthing.otherdemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUnsafeExample {
    //    private AtomicInteger cnt = new AtomicInteger(0);
    private int cnt = 0;
    public void add(){
//        cnt.incrementAndGet();
        cnt++;
    }
    public int get(){
//        return cnt.get();
        return cnt;
    }


    public static void main(String[] args) throws InterruptedException {
        final int size = 1000;
        ThreadUnsafeExample threadUnsafeExample = new ThreadUnsafeExample();
        CountDownLatch countDownLatch = new CountDownLatch(size);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < size; i++) {
            executorService.execute(()->{
                threadUnsafeExample.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(threadUnsafeExample.get());

    }

}
