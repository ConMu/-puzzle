package basething.threadthing.proandcon;

public class Producer implements Runnable{
    private ClotheFactory clotheFactory;

    public Producer(ClotheFactory clotheFactory) {
        this.clotheFactory = clotheFactory;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
                clotheFactory.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
