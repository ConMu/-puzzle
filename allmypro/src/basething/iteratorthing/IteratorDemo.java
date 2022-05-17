package basething.iteratorthing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * test iterator remove
 *
 * @author mucongcong
 * @date 2022/05/17 10:19
 * @since
 **/
public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("1", "2", "3"));
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == "1") iterator.remove();
        }
        System.out.println(strings);
//        System.out.println(iterator);
    }
}
