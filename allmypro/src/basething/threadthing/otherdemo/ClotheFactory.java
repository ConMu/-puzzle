package basething.threadthing.otherdemo;

import java.util.LinkedList;

public class ClotheFactory {
    private final int size = 10;
    private LinkedList<Object> list = new LinkedList<>();

    public void produce(){
        synchronized (list) {
            while (list.size() >= 10) {
                System.out.println("生产者" + Thread.currentThread().getName() + "仓库已满");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println(Thread.currentThread().getName() + "生产衣服，现存容量" + list.size());
            list.notifyAll();
        }
    }

    public void consume(){
        synchronized (list) {
            while (list.size() <= 0) {
                System.out.println("消费者" + Thread.currentThread().getName() + "仓库无货");
            }
            try {
                list.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.removeLast();
            System.out.println(Thread.currentThread().getName() + "消费衣服，现存容量" + list.size());
            list.notifyAll();
        }
    }
}
