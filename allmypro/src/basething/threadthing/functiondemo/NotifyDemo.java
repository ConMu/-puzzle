package basething.threadthing.functiondemo;

public class NotifyDemo {
    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("A得到资源A的锁");
                    try {
                        System.out.println("A begin");
                        resourceA.wait();
                        System.out.println("A end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("B得到资源A的锁");


                    try {
                        System.out.println("B begin");
                        resourceA.wait();
                        System.out.println("B end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("C 开始notify");
//                    resourceA.notify();
                    resourceA.notifyAll();
                }
            }
        });
        threadA.start();
        threadB.start();
        Thread.sleep(1000);
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("over");

    }
}
