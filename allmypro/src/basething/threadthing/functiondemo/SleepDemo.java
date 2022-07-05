package basething.threadthing.functiondemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SleepDemo {

    //独占锁
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();

                try {
                    System.out.println("threadA is to sleep");
                    Thread.sleep(10000);
                    System.out.println("A sleep over");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();

                try {
                    System.out.println("threadB is to sleep");
                    Thread.sleep(10000);
                    System.out.println("B sleep over");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

//        threadA.start();
//        threadB.start();
        //尝试看sleep时被interrupt，会不会抛出异常
        threadA.start();
        Thread.sleep(2000);
        threadA.interrupt();


    }
}
