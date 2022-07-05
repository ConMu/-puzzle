package basething.threadthing.functiondemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample {

    public void func1() {
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                System.out.println(i);

            }
        }
    }

    public static void main(String[] args) {
//        SynchronizedExample se = new SynchronizedExample();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                se.func1();
//            }
//        });
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                se.func1();
//            }
//        });

        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        executorService2.execute(() -> e1.func1());
        executorService2.execute(() -> e2.func1());
    }
}
