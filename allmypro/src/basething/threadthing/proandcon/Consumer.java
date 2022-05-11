package basething.threadthing.proandcon;

public class Consumer implements Runnable{
    ClotheFactory clotheFactory;

    public Consumer(ClotheFactory clotheFactory) {
        this.clotheFactory = clotheFactory;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
                clotheFactory.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
