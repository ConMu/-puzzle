package basething.threadthing.otherdemo;

public class DeadLockTest {

    //资源
    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread() + "get A re");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread() + "wait B re");
                    synchronized (resourceB) {
                        System.out.println(Thread.currentThread() + "get B re");
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread() + "get B re");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread() + "wait A re");
                    synchronized (resourceA) {
                        System.out.println(Thread.currentThread() + "get A re");
                    }
                }
            }
        });

        threadA.start();
        threadB.start();


    }

}
