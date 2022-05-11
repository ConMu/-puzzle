package basething.threadthing.disignmode;
//双重检验锁
public class Singleton {
    private volatile static Singleton singleton;
    private Singleton(){}

    public static Singleton get(){
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
