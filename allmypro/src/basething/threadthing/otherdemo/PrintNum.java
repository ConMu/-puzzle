package basething.threadthing.otherdemo;

public class PrintNum implements Runnable{
    private int num;
    private boolean flag;
    private Object lock;

    public PrintNum(int num, boolean flag, Object lock) {
        this.num = num;
        this.flag = flag;
        this.lock = lock;
    }


    @Override
    public void run() {
        synchronized (lock) {
            while (num <= 100) {
                if (flag) {
                    flag = false;
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(num);
                num += 2;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Object o = new Object();
        Thread t1 = new Thread(new PrintNum(1, true, o));
        Thread t2 = new Thread(new PrintNum(2, false, o));
        t2.start();
        t1.start();
    }
}


