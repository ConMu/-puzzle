package basething.constructor;

import java.util.Date;

public class FormatDemo {
    public static void main(String[] args) {
        String format = String.format("%,.2f", 1000000.0000);
        System.out.println(format);
//        Class<String> stringClass = String.class;

        System.out.println(String.format("%tc", new Date()));
        System.out.println(String.format("%tr", new Date()));

    }
}
