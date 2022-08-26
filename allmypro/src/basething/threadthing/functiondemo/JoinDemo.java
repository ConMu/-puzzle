package basething.threadthing.functiondemo;

/**
 * 线程join方法执行
 *
 * @author mucongcong
 * @date 2022/06/23 10:00
 * @since
 **/
public class JoinDemo {
    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            JoinThread curThread = new JoinThread(previousThread);
            curThread.start();
            previousThread = curThread;
        }
    }

    static class JoinThread extends Thread {
        private Thread thread;

        public JoinThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
                System.out.println(thread.getName()+" terminated.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
