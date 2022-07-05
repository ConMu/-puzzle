package basething.threadthing.functiondemo;

public class ThreadLocalTest {
    static ThreadLocal<String> localV = new ThreadLocal<>();

    static void print1(String string) {
        //1 1 打印当前线程本地内存中 localVariable变莹的位
        System.out.println(string + localV.get());
        //1 . 2 清除当前线程本地内存 中的 localVariable 交量
        localV.remove() ;
    }

    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {

                //3 . 1 设置线程One 中本地交 localVariable 的位
                localV.set("threadOne local variable");
                //3 . 2 调用打印函数
                print1("threadOne");
                //3 . 3 打印本地变量值
                System.out.println("threadOne remove after" + ":" + localV.get());
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {

                //3 . 1 设置线程One 中本地交 localVariable 的位
                localV.set("threadTwo local variable");
                //3 . 2 调用打印函数
                print2("threadTwo");
                //3 . 3 打印本地变量值
                System.out.println("threadTwo remove after" + ":" + localV.get());
            }
        });

        threadOne.start();
        threadTwo.start();

    }

    private static void print2(String string) {
        //1 1 打印当前线程本地内存中 localVariable变莹的位
        System.out.println(string + localV.get());
        //1 . 2 清除当前线程本地内存 中的 localVariable 交量
//        localV.remove() ;
    }
}
