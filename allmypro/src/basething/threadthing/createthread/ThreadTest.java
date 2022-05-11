package basething.threadthing.createthread;

public class ThreadTest {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(111);
        }
    }

    public static void main(String[] args) {
        MyThread thread= new MyThread ();
        thread.start();
    }
}
