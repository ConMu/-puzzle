package basething.threadthing.otherdemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author mucongcong
 * @date 2022/07/05 09:35
 * @since
 **/
public class CountDownLatchMoudle {
    //线程数
    private static int N = 10;

    //单位：min
    private static int countDownLatchTimeOut = 5;

    public static void main(String[] args) {
        //创建CountDownLatch并设置计数值，该count值可以根据线程数的需要设置
        CountDownLatch countDownLatch = new CountDownLatch(N);

        //创建线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < N; i++) {
            cachedThreadPool.execute(() -> {
                try {
                    Thread.sleep(6*1000);
                    System.out.println(Thread.currentThread().getName() + "do someThing!");
                } catch (Exception e) {
                    System.out.println("Exception : do something exception");
                } finally {
                    //线程数完毕-1
                    countDownLatch.countDown();
                }
            });
        }
        System.out.println("main thread do something ");
        try {
            // 再有限时间内 异步请求的 CountDownLatch计数减不到 0
            if (!countDownLatch.await(countDownLatchTimeOut, TimeUnit.SECONDS)) {
                System.out.println("==超时==");
            }
        } catch (InterruptedException e) {
            System.out.println("Exception : await interrupted exception");
        } finally {
            System.out.println("countDownLatch: " + countDownLatch.toString());
        }

        System.out.println("main thread do something-2");

        //若需要停止线程池可关闭;
//        cachedThreadPool.shutdown();
    }


}
