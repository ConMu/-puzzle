package basething.arraydemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author mucongcong
 * @date 2022/05/24 15:20
 * @since
 **/
public class ArrayDemo01 {
    public static void main(String[] args) {
//        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
//        dealArray(integers);
//        System.out.println(integers);
        dfs();
//        String[] strings = new String[]{"1", "ds"};
//        List<String> list = Arrays.asList(strings);
//        list.add("ad");
    }

    private static void dfs() {
        Book book = new Book();
        dfs();
    }

    static class Book{

    }

    private static void dealArray(ArrayList<Integer> integers) {
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == 1) {
                iterator.remove();
            }
        }
    }
}
