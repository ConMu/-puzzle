package basething.constructor;

public class DuckTestDemo {
    public static void main(String[] args) {
        Duck duck1 = new Duck();

        Duck duck2 = new Duck();
//        System.out.println(Duck.getCount());

        System.out.println(duck1.getCount());
        System.out.println(duck2.getCount());

    }
}
