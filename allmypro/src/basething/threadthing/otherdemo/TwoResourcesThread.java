package basething.threadthing.otherdemo;

public class TwoResourcesThread {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("A得到资源A的锁");
                    synchronized (resourceB) {
                        System.out.println("A得到资源B的锁");
                        System.out.println("A释放A的锁");
                        try {
                            resourceA.wait();
                            System.out.println("A释放B的锁");
                            resourceB.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    synchronized (resourceA) {
                        System.out.println("B拿到A的锁");
                        System.out.println("B尝试拿B的锁");
                        synchronized (resourceB) {
                            System.out.println("B拿到了B的锁");
                            System.out.println("B释放A的锁");
                            resourceB.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("main over");

    }
}
