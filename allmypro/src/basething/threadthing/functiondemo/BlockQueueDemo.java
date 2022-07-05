package basething.threadthing.functiondemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueueDemo {
    private static BlockingQueue<String> bq = new ArrayBlockingQueue<>(5);

    public static class Producer extends Thread {
        @Override
        public void run() {
            try {
                bq.put("produce");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("produce..");
        }
    }

    public static class Consumer extends Thread {
        @Override
        public void run() {
            try {
                bq.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("consume");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Producer producer = new Producer();
            producer.start();
        }
        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }
        for (int i = 0; i < 2; i++) {
            Producer producer = new Producer();
            producer.start();
        }

    }

}
