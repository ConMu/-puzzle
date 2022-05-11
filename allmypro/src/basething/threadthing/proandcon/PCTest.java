package basething.threadthing.proandcon;

public class PCTest {
    public static void main(String[] args) {
        ClotheFactory clotheFactory = new ClotheFactory();
        Thread p1 = new Thread(new Producer(clotheFactory), "生产者1");
        Thread p2 = new Thread(new Producer(clotheFactory), "生产者2");
        Thread p3 = new Thread(new Producer(clotheFactory), "生产者3");

        Thread c1 = new Thread(new Consumer(clotheFactory), "消费者1");
        Thread c2 = new Thread(new Consumer(clotheFactory), "消费者2");
        Thread c3 = new Thread(new Consumer(clotheFactory), "消费者3");

        p1.start();
        p2.start();
        p3.start();

        c1.start();
        c2.start();
        c3.start();

    }
}
