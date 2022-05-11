package basething.threadthing.createthread;

public class RunableTask implements Runnable{
    @Override
    public void run() {
        System.out.println ("I am a ch i ld thread" ) ;
    }

    public static void main(String[] args) {
        RunableTask runableTask = new RunableTask();
        new Thread(runableTask).start();
        new Thread(runableTask).start();

    }
}
