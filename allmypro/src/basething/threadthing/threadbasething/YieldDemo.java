package basething.threadthing.threadbasething;

public class YieldDemo implements Runnable{
    YieldDemo(){
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            //当 i=O 时让出 CPU执行权，放弃时 间片，进行下一轮调度
            if ((i % 5) == 0) {
                System.out.println(Thread.currentThread()+ "yield cpu...");
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread()+"over");
    }

    public static void main(String[] args) {
        new YieldDemo();
        new YieldDemo();
        new YieldDemo();
    }
}
